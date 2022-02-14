# nubank-stack

Nubank Stack

### Backend
- [x] Income  - Microsserviço responsável pela parte de rendimentos
- [x] Wallet  - Microsserviço responsável pela parte de carteiras
- [ ] Auth    - Authentication operations
- [ ] Account - Contains methods to access the user account details and the checking account transactions and bills
- [ ] Card    - Contains methods to retrieve the feed of transactions from the credit card
- [ ] Payment - Contains methods to create payment requests



### Front
* Web - Cliente responsivo 

### Infra
* Load Balance - Redirecionador de requisições 
* MongoDB      - Persistência


### How to run

```
docker-compose up
```

Then access 

http://localhost:3000

SwaggerUI

http://localhost:9090

All Services 

| Service      | Network |  Port |
|--------------|:-------:|------:|
| Web          |  Front  |  3000 |
| Load balance |  Front  |  3005 |
| SwaggerUI    |  Front  |  9090 |
| Income       |  Back   |  8081 |
| Wallet       |  Back   |  8082 |
| MongoDB      |  Back   | 27017 |


