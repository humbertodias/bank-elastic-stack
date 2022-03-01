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
	kubectl apply -f mongo-data-persistentvolumeclaim.yaml,mongo-service.yaml,mongo-deployment.yaml,\
	account-service.yaml,account-deployment.yaml,\
	income-service.yaml,income-deployment.yaml,\
	wallet-service.yaml,wallet-deployment.yaml,\
	web-service.yaml,web-deployment.yaml,\
	lb-service.yaml,lb-deployment.yaml,\
	swagger-ui-service.yaml,swagger-ui-deployment.yaml

k8s-delete:
	cd infra/k8s &&\
	kubectl delete -f mongo-data-persistentvolumeclaim.yaml,mongo-service.yaml,mongo-deployment.yaml,\
	account-service.yaml,account-deployment.yaml,\
	income-service.yaml,income-deployment.yaml,\
	wallet-service.yaml,wallet-deployment.yaml,\
	web-service.yaml,web-deployment.yaml,\
	lb-service.yaml,lb-deployment.yaml,\
	swagger-ui-service.yaml,swagger-ui-deployment.yaml	

k8s-start:
	$(MAKE) k8s-apply
	sleep 10
	bash infra/k8s/port-forward.sh web 3001
	bash infra/k8s/port-forward.sh swagger-ui 3002

k8s-stop:
	kill `lsof -t -i :3001`
	kill `lsof -t -i :3002`
	$(MAKE) k8s-delete
