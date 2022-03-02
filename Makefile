docker-build:
	cd app/backend/account && docker build . -t account:0.0.1-SNAPSHOT
	cd app/backend/income && docker build . -t income:0.0.1-SNAPSHOT
	cd app/backend/wallet && docker build . -t wallet:0.0.1-SNAPSHOT
	cd app/frontend/web && docker build . -t web:0.0.1
	cd app/frontend/lb && docker build . -t lb:0.0.1

docker-push:
	docker tag account:0.0.1-SNAPSHOT hldtux/account:0.0.1-SNAPSHOT && docker push hldtux/account:0.0.1-SNAPSHOT
	docker tag income:0.0.1-SNAPSHOT hldtux/income:0.0.1-SNAPSHOT && docker push hldtux/income:0.0.1-SNAPSHOT
	docker tag wallet:0.0.1-SNAPSHOT hldtux/wallet:0.0.1-SNAPSHOT && docker push hldtux/wallet:0.0.1-SNAPSHOT
	docker tag web:0.0.1 hldtux/web:0.0.1 && docker push hldtux/web:0.0.1
	docker tag lb:0.0.1 hldtux/lb:0.0.1 && docker push hldtux/lb:0.0.1
	
k8s-apply:
	cd infra/k8s &&\
	kubectl apply --namespace=nubank -f namespace.yaml,\
	mongo-data-persistentvolumeclaim.yaml,mongo-service.yaml,mongo-deployment.yaml,\
	gradle-cache-persistentvolumeclaim.yaml,\
	account-service.yaml,account-deployment.yaml,\
	income-service.yaml,income-deployment.yaml,\
	wallet-service.yaml,wallet-deployment.yaml,\
	web-service.yaml,web-deployment.yaml,\
	lb-service.yaml,lb-deployment.yaml,\
	swagger-ui-service.yaml,swagger-ui-deployment.yaml

k8s-delete:
	cd infra/k8s &&\
	kubectl delete -f mongo-data-persistentvolumeclaim.yaml,mongo-service.yaml,mongo-deployment.yaml,\
	gradle-cache-persistentvolumeclaim.yaml,\
	account-service.yaml,account-deployment.yaml,\
	income-service.yaml,income-deployment.yaml,\
	wallet-service.yaml,wallet-deployment.yaml,\
	web-service.yaml,web-deployment.yaml,\
	lb-service.yaml,lb-deployment.yaml,\
	swagger-ui-service.yaml,swagger-ui-deployment.yaml,\
	namespace.yaml	

forward-port:
	bash infra/port-forward.sh web 3001 nubank
	bash infra/port-forward.sh swagger-ui 3002 nubank
	bash infra/port-forward.sh lb 3005 nubank

close-port:
	kill `lsof -t -i :3001`
	kill `lsof -t -i :3002`
	kill `lsof -t -i :3005`

start:
	$(MAKE) k8s-apply
	sleep 10
	$(MAKE) forward-port

stop:
	# $(MAKE) k8s-delete
	$(MAKE) k8s-delete-namespace
	$(MAKE) close-port

helm-install:
	$(MAKE) k8s-create-namespace
	helm install --namespace nubank --set name=mongo mongo infra/helm/mongo
	helm install --namespace nubank --set name=account account infra/helm/account
	helm install --namespace nubank --set name=income income infra/helm/income
	helm install --namespace nubank --set name=wallet wallet infra/helm/wallet
	helm install --namespace nubank --set name=lb lb infra/helm/lb
	helm install --namespace nubank --set name=web web infra/helm/web
	helm install --namespace nubank --set name=swagger-ui swagger-ui infra/helm/swagger-ui
	sleep 10
	$(MAKE) forward-port

helm-upgrade:
	helm upgrade --namespace nubank --set name=mongo mongo infra/helm/mongo
	helm upgrade --namespace nubank --set name=account account infra/helm/account
	helm upgrade --namespace nubank --set name=income income infra/helm/income
	helm upgrade --namespace nubank --set name=wallet wallet infra/helm/wallet
	helm upgrade --namespace nubank --set name=lb lb infra/helm/lb
	helm upgrade --namespace nubank --set name=web web infra/helm/web
	helm upgrade --namespace nubank --set name=swagger-ui swagger-ui infra/helm/swagger-ui

helm-uninstall:
	# helm uninstall `helm ls --namespace nubank -q`
	$(MAKE) k8s-delete-namespace
	$(MAKE) close-port

k8s-create-namespace:
	cd infra/k8s && kubectl create -f namespace.yaml

k8s-delete-namespace:
	kubectl delete namespaces nubank

clean:
	cd app/backend && rm -rf account/build income/build wallet/build
	cd app/frontend && rm -rf web/build
