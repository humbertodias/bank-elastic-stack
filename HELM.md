# Kubernetes - Helm

```
make helm-install
```

wait until everything starts up

```
make forward-port
```

Then access

http://localhost:3001

and

http://localhost:3002


Scale

```
helm upgrade --namespace bank --set replicaCount=2 account infra/helm/account
```

Stop

```
make helm-uninstall
```