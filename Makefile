NAMESPACE=bank

AWS_CONTEXT=arn:aws:eks:sa-east-1:110464496991:cluster/my-cluster
AWS_REGION=sa-east-1
AWS_USERNAME=humbertodias-common
AWS_CLUSTER_NAME=my-cluster

docker-build:
	cd app/backend && \
	docker build account -t account:0.0.1-SNAPSHOT && \
	docker build . -f income/Dockerfile -t income:0.0.1-SNAPSHOT && \
	docker build . -f wallet/Dockerfile -t wallet:0.0.1-SNAPSHOT && \
	docker build . -f mq/Dockerfile -t mq:0.0.1-SNAPSHOT && \
	docker build . -f cm/Dockerfile -t cm:0.0.1-SNAPSHOT
	cd app/frontend && \
	docker build web -t web:0.0.1 && \
	docker build lb -t lb:0.0.1

docker-push:
	docker tag account:0.0.1-SNAPSHOT hldtux/account:0.0.1-SNAPSHOT && docker push hldtux/account:0.0.1-SNAPSHOT
	docker tag income:0.0.1-SNAPSHOT hldtux/income:0.0.1-SNAPSHOT && docker push hldtux/income:0.0.1-SNAPSHOT
	docker tag wallet:0.0.1-SNAPSHOT hldtux/wallet:0.0.1-SNAPSHOT && docker push hldtux/wallet:0.0.1-SNAPSHOT
	docker tag mq:0.0.1-SNAPSHOT hldtux/mq:0.0.1-SNAPSHOT && docker push hldtux/mq:0.0.1-SNAPSHOT
	docker tag cm:0.0.1-SNAPSHOT hldtux/cm:0.0.1-SNAPSHOT && docker push hldtux/cm:0.0.1-SNAPSHOT
	docker tag web:0.0.1 hldtux/web:0.0.1 && docker push hldtux/web:0.0.1
	docker tag lb:0.0.1 hldtux/lb:0.0.1 && docker push hldtux/lb:0.0.1

docker-rmi:
	docker images -f "dangling=true" -q | xargs docker rmi -f 
	echo account:0.0.1-SNAPSHOT income:0.0.1-SNAPSHOT wallet:0.0.1-SNAPSHOT hldtux/account:0.0.1-SNAPSHOT hldtux/income:0.0.1-SNAPSHOT hldtux/wallet:0.0.1-SNAPSHOT hldtux/mq:0.0.1-SNAPSHOT hldtux/cm:0.0.1-SNAPSHOT | xargs docker rmi -f

k8s-apply:
	$(MAKE) k8s-create-namespace
	kubectl apply --namespace=$(NAMESPACE) -f infra/k8s -R

k8s-delete:
	kubectl delete --namespace=$(NAMESPACE) -f infra/k8s -R

k8s-use-context-rancher:
	kubectl config use-context rancher-desktop

k8s-use-context-aws:
	kubectl config use-context $(AWS_CONTEXT)

k8s-start:
	$(MAKE) k8s-apply
	sleep 20
	$(MAKE) forward-port
	#$(MAKE) k8s-set-env

k8s-set-env:
	kubectl expose deployment lb --name=lb-lb --type=LoadBalancer -n $(NAMESPACE)
	sleep 10
	$(eval HOST=`kubectl get svc lb-lb -n bank -o json | jq .status.loadBalancer.ingress[].ip -r`)
	$(eval PORT=`kubectl get svc lb-lb -n bank -o json | jq .spec.ports[].nodePort`)
	echo "$(HOST):$(PORT)"
	kubectl set env deployment/web -n bank REACT_APP_LB_HOST=localhost
	kubectl set env deployment/web -n bank REACT_APP_LB_PORT=$(PORT)
	sleep 10
	bash infra/port-forward.sh web 3001 $(NAMESPACE)

k8s-stop:
	$(MAKE) k8s-delete
	$(MAKE) k8s-delete-namespace
	$(MAKE) close-port

k8s-create-namespace:
	kubectl create namespace $(NAMESPACE)

k8s-delete-namespace:
	kubectl delete namespaces $(NAMESPACE)

k8s-memory:
	kubectl top pod --namespace=$(NAMESPACE)

k8s-expose:
	#kubectl expose deployment web --name=web-lb --type=LoadBalancer -n $(NAMESPACE)
	kubectl expose deployment swagger-ui --name=swagger-ui-lb --type=LoadBalancer -n $(NAMESPACE)
	kubectl expose deployment lb --name=lb-lb --type=LoadBalancer -n $(NAMESPACE)
	kubectl expose deployment rabbitmq --name=rabbitmq-lb --type=LoadBalancer -n $(NAMESPACE)
	kubectl get svc -n $(NAMESPACE)

k8s-unexpose:
	kubectl delete service web-lb -n $(NAMESPACE)
	kubectl delete service swagger-ui-lb -n $(NAMESPACE)
	kubectl delete service lb-lb -n $(NAMESPACE)
	kubectl delete service rabbitmq-lb -n $(NAMESPACE)
	kubectl get svc -n $(NAMESPACE)

forward-port:
	bash infra/port-forward.sh web 3001 $(NAMESPACE)
	bash infra/port-forward.sh swagger-ui 3002 $(NAMESPACE)
	bash infra/port-forward.sh lb 3005 $(NAMESPACE)
	bash infra/port-forward.sh rabbitmq 15672 $(NAMESPACE)

close-port:
	lsof -t -i :3001 | xargs -r kill
	lsof -t -i :3002 | xargs -r kill
	lsof -t -i :3005 | xargs -r kill
	lsof -t -i :15672 | xargs -r kill

helm-install:
	$(MAKE) k8s-create-namespace
	helm install --namespace $(NAMESPACE) --set name=mongo mongo infra/helm/mongo
	helm install --namespace $(NAMESPACE) --set name=rabbitmq rabbitmq infra/helm/rabbitmq
	helm install --namespace $(NAMESPACE) --set name=account account infra/helm/account
	helm install --namespace $(NAMESPACE) --set name=income income infra/helm/income
	helm install --namespace $(NAMESPACE) --set name=wallet wallet infra/helm/wallet
	helm install --namespace $(NAMESPACE) --set name=lb lb infra/helm/lb
	helm install --namespace $(NAMESPACE) --set name=web web infra/helm/web
	helm install --namespace $(NAMESPACE) --set name=mq mq infra/helm/mq
	helm install --namespace $(NAMESPACE) --set name=cm cm infra/helm/cm
	helm install --namespace $(NAMESPACE) --set name=swagger-ui swagger-ui infra/helm/swagger-ui
	sleep 20
	$(MAKE) forward-port

helm-upgrade:
	helm upgrade --namespace $(NAMESPACE) --set name=mongo mongo infra/helm/mongo
	helm upgrade --namespace $(NAMESPACE) --set name=rabbitmq rabbitmq infra/helm/rabbitmq
	helm upgrade --namespace $(NAMESPACE) --set name=account account infra/helm/account
	helm upgrade --namespace $(NAMESPACE) --set name=income income infra/helm/income
	helm upgrade --namespace $(NAMESPACE) --set name=wallet wallet infra/helm/wallet
	helm upgrade --namespace $(NAMESPACE) --set name=lb lb infra/helm/lb
	helm upgrade --namespace $(NAMESPACE) --set name=web web infra/helm/web
	helm upgrade --namespace $(NAMESPACE) --set name=mq mq infra/helm/mq
	helm upgrade --namespace $(NAMESPACE) --set name=cm cm infra/helm/cm
	helm upgrade --namespace $(NAMESPACE) --set name=swagger-ui swagger-ui infra/helm/swagger-ui

helm-uninstall:
	helm uninstall --namespace $(NAMESPACE) mongo
	helm uninstall --namespace $(NAMESPACE) rabbitmq
	helm uninstall --namespace $(NAMESPACE) account
	helm uninstall --namespace $(NAMESPACE) income
	helm uninstall --namespace $(NAMESPACE) wallet
	helm uninstall --namespace $(NAMESPACE) lb
	helm uninstall --namespace $(NAMESPACE) web
	helm uninstall --namespace $(NAMESPACE) mq
	helm uninstall --namespace $(NAMESPACE) cm
	helm uninstall --namespace $(NAMESPACE) swagger-ui
	$(MAKE) k8s-delete-namespace
	$(MAKE) close-port

clean:
	cd app/backend && rm -rf account/build income/build wallet/build mq/build cm/build
	cd app/frontend && rm -rf web/build

clean-gradle:
	find . -name ".gradle" -exec rm -rf "{}" \;

argocd-install:
	wget https://github.com/argoproj/argo-cd/releases/download/v2.2.5/argocd-linux-amd64 -O /usr/local/bin/argocd
	chmod +x /usr/local/bin/argocd 
	
	kubectl create namespace argocd
	kubectl apply -n argocd -f https://raw.githubusercontent.com/argoproj/argo-cd/v2.2.5/manifests/install.yaml
	sleep 20

	echo "Visit http://localhost:8080 using user:admin password:"
	kubectl -n argocd get secret argocd-initial-admin-secret -o jsonpath="{.data.password}" | base64 -d
	@echo ""
	kubectl port-forward svc/argocd-server -n argocd 8080:443 &
	
	argocd login localhost:8080 --username admin --insecure

	kubectl create namespace argo-bank
	argocd app create mongo --repo https://github.com/humbertodias/bank-elastic-stack.git --path infra/helm/mongo --dest-namespace argo-bank --dest-server https://kubernetes.default.svc --helm-set replicaCount=0
	argocd app create account --repo https://github.com/humbertodias/bank-elastic-stack.git --path infra/helm/account --dest-namespace argo-bank --dest-server https://kubernetes.default.svc --helm-set replicaCount=0

argocd-uninstall:
	kubectl delete namespaces argocd

aws-cli-install:
	curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip"
	unzip awscliv2.zip
	sudo ./aws/install
	rm -rf aws awscliv2.zip

aws-configure:
	aws configure import --csv file://~/Downloads/humbertodias-common_accessKeys.csv
	aws configure list

aws-login:
	aws eks update-kubeconfig --region $(AWS_REGION) --name $(AWS_CLUSTER_NAME)
