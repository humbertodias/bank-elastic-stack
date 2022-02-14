# nubank-stack

Nubank Stack

### Backend
* Income - Microsserviço responsável pela parte de rendimentos
* Wallet - Microsserviço responsável pela parte de carteiras

### Front
* Web

### Infra
* Load Balance
* Mongo


### How to run

```
docker-compose up
```

Then access 

http://localhost:3000


All Services 

| Service      | Network |  Port |
|--------------|:-------:|------:|
| Web          |  Front  |  3000 |
| Load balance |  Front  |  3005 |
| Income       |  Back   |  8081 |
| Wallet       |  Back   |  8082 |
| Mongo        |  Back   | 27017 |


