NAMESPACE=bank

docker-build:
	cd app/backend/account && docker build . -t account:0.0.1-SNAPSHOT
	cd app/backend/income && docker build . -t income:0.0.1-SNAPSHOT
	cd app/backend/wallet && docker build . -t wallet:0.0.1-SNAPSHOT
	#cd app/backend/account && ./gradlew bootBuildImage
	#cd app/backend/income && ./gradlew bootBuildImage
	#cd app/backend/wallet && ./gradlew bootBuildImage
	cd app/frontend/web && docker build . -t web:0.0.1
	cd app/frontend/lb && docker build . -t lb:0.0.1

docker-push:
	docker tag account:0.0.1-SNAPSHOT hldtux/account:0.0.1-SNAPSHOT && docker push hldtux/account:0.0.1-SNAPSHOT
	docker tag income:0.0.1-SNAPSHOT hldtux/income:0.0.1-SNAPSHOT && docker push hldtux/income:0.0.1-SNAPSHOT
	docker tag wallet:0.0.1-SNAPSHOT hldtux/wallet:0.0.1-SNAPSHOT && docker push hldtux/wallet:0.0.1-SNAPSHOT
	docker tag web:0.0.1 hldtux/web:0.0.1 && docker push hldtux/web:0.0.1
	docker tag lb:0.0.1 hldtux/lb:0.0.1 && docker push hldtux/lb:0.0.1
	
k8s-apply:
	$(MAKE) k8s-create-namespace
	cd infra/k8s &&\
	kubectl apply --namespace=$(NAMESPACE) -f mongo-data-persistentvolumeclaim.yaml,mongo-service.yaml,mongo-deployment.yaml,\
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
	swagger-ui-service.yaml,swagger-ui-deployment.yaml

forward-port:
	bash infra/port-forward.sh web 3001 $(NAMESPACE)
	bash infra/port-forward.sh swagger-ui 3002 $(NAMESPACE)
	bash infra/port-forward.sh lb 3005 $(NAMESPACE)

close-port:
	lsof -t -i :3001 | xargs -r kill
	lsof -t -i :3002 | xargs -r kill
	lsof -t -i :3005 | xargs -r kill

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
	helm install --namespace $(NAMESPACE) --set name=mongo mongo infra/helm/mongo
	helm install --namespace $(NAMESPACE) --set name=account account infra/helm/account
	helm install --namespace $(NAMESPACE) --set name=income income infra/helm/income
	helm install --namespace $(NAMESPACE) --set name=wallet wallet infra/helm/wallet
	helm install --namespace $(NAMESPACE) --set name=lb lb infra/helm/lb
	helm install --namespace $(NAMESPACE) --set name=web web infra/helm/web
	helm install --namespace $(NAMESPACE) --set name=swagger-ui swagger-ui infra/helm/swagger-ui
	sleep 10
	$(MAKE) forward-port

helm-upgrade:
	helm upgrade --namespace $(NAMESPACE) --set name=mongo mongo infra/helm/mongo
	helm upgrade --namespace $(NAMESPACE) --set name=account account infra/helm/account
	helm upgrade --namespace $(NAMESPACE) --set name=income income infra/helm/income
	helm upgrade --namespace $(NAMESPACE) --set name=wallet wallet infra/helm/wallet
	helm upgrade --namespace $(NAMESPACE) --set name=lb lb infra/helm/lb
	helm upgrade --namespace $(NAMESPACE) --set name=web web infra/helm/web
	helm upgrade --namespace $(NAMESPACE) --set name=swagger-ui swagger-ui infra/helm/swagger-ui

helm-uninstall:
	# helm uninstall `helm ls --namespace nubank -q`
	$(MAKE) k8s-delete-namespace
	$(MAKE) close-port

k8s-create-namespace:
	kubectl create namespace $(NAMESPACE)

k8s-delete-namespace:
	kubectl delete namespaces $(NAMESPACE)

clean:
	cd app/backend && rm -rf account/build income/build wallet/build
	cd app/frontend && rm -rf web/build

docker-rmi:
	docker images -f "dangling=true" -q | xargs docker rmi -f 
	echo account:0.0.1-SNAPSHOT income:0.0.1-SNAPSHOT wallet:0.0.1-SNAPSHOT hldtux/account:0.0.1-SNAPSHOT hldtux/income:0.0.1-SNAPSHOT hldtux/wallet:0.0.1-SNAPSHOT | xargs docker rmi -f