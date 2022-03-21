# Push Notification

1. Inicie a stack

```
docker compose up -d
```

2. Permita a execuçao da notificaçao e copie o token gerado em

http://localhost:3001/cm.html

![](doc/cm-granted-device-token.png)

3. Acesse a api CM (Cloud Messaging) e execute o endpoint /send-notification-token com token copiado em

http://localhost:3002/

![](doc/cm-send-notification-token.png)

Resultado

![](doc/cm-notification-popup.png)
