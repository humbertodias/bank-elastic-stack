## Stack

Projeto desenvolvido com Ionic + React.

## Como rodar o projeto

É necessário ter algum gerenciador de pacotes instalado na sua máquina. Ex: `NPM` ou `Yarn`.

1. Instalar dependências:
   `npm install` ou `yarn`

2. Rodar o projeto localmente:
   `ionic serve`

Após isso você poderá acessar o app pelo endereço:
`http://localhost:8100/`


# Push Notification

1. Inicie a stack

```
docker compose up
```

2. Permita a execuçao da notificaçao e copie o token gerado em

http://localhost:3001/cm.html

3. Acesse a api CM (Cloud Messaging) e execute o endpoint /send-notification-token

http://localhost:3002/