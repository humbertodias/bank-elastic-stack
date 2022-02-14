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

SwaggerUI

http://localhost:9090/

All Services 

| Service      | Network |  Port |
|--------------|:-------:|------:|
| Web          |  Front  |  3000 |
| Load balance |  Front  |  3005 |
| SwaggerUI    |  Front  |  9090 |
| Income       |  Back   |  8081 |
| Wallet       |  Back   |  8082 |
| MongoDB      |  Back   | 27017 |


