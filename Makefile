docker-build:
	cd backend/account && docker build . -t account:0.0.1-SNAPSHOT
	cd backend/income && docker build . -t income:0.0.1-SNAPSHOT
	cd backend/wallet && docker build . -t wallet:0.0.1-SNAPSHOT
	cd frontend/web && docker build . -t web:0.0.1
	cd infra/lb && docker build . -t lb:0.0.1

docker-push:
	docker tag account:0.0.1-SNAPSHOT hldtux/account:0.0.1-SNAPSHOT && docker push hldtux/account:0.0.1-SNAPSHOT
	docker tag income:0.0.1-SNAPSHOT hldtux/income:0.0.1-SNAPSHOT && docker push hldtux/income:0.0.1-SNAPSHOT
	docker tag wallet:0.0.1-SNAPSHOT hldtux/wallet:0.0.1-SNAPSHOT && docker push hldtux/wallet:0.0.1-SNAPSHOT
	docker tag web:0.0.1 hldtux/web:0.0.1 && docker push hldtux/web:0.0.1
	docker tag lb:0.0.1 hldtux/lb:0.0.1 && docker push hldtux/lb:0.0.1
	
k8s-apply:
	cd k8s &&\
	kubectl apply -f mongo-data-persistentvolumeclaim.yaml,mongo-service.yaml,mongo-deployment.yaml,\
	account-service.yaml,account-deployment.yaml,\
	income-service.yaml,income-deployment.yaml,\
	wallet-service.yaml,wallet-deployment.yaml,\
	web-service.yaml,web-deployment.yaml,\
	lb-service.yaml,lb-deployment.yaml,\
	swagger-ui-service.yaml,swagger-ui-deployment.yaml

k8s-delete:
	cd k8s &&\
	kubectl delete -f mongo-data-persistentvolumeclaim.yaml,mongo-service.yaml,mongo-deployment.yaml,\
	account-service.yaml,account-deployment.yaml,\
	income-service.yaml,income-deployment.yaml,\
	wallet-service.yaml,wallet-deployment.yaml,\
	web-service.yaml,web-deployment.yaml,\
	lb-service.yaml,lb-deployment.yaml,\
	swagger-ui-service.yaml,swagger-ui-deployment.yaml	

k8s-ports:
	sleep 10
	bash k8s-ports.sh

k8s-publish:	k8s-apply	k8s-ports