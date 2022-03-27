# Kubernetes - Helm

```
make helm-install
```

wait until everything starts up

```
make forward-port
```

Then access

http://localhost:3001 or http://web.localhost:3001

and 

http://localhost:3002 or http://swagger-ui.localhost:3002


Scale

```
helm upgrade --namespace bank --set replicaCount=2 account infra/helm/account
```

Stop

```
make helm-uninstall
```

# Ref

* [Ingress CORS](https://torchbox.github.io/k8s-ts-ingress/cors/)