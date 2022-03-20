# bank-elastic-stack

Elastic stack using :

1. Docker - Compose
2. Kubernetes - Native
3. Kubernetes - Helm

## Requirements

* [rancher desktop](https://rancherdesktop.io/)
* [helm](https://rancherdesktop.io/)
* [k8slens](https://k8slens.dev/)

## Front
* Web - Cliente responsivo 

Wallet/Income

![](doc/wallet.png)
![](doc/income-cdi.png)

## Infra
* Load Balance - Redirecionador de requisições 
* MongoDB      - Persistência

```mermaid
graph TD
    A[fa:fa-mobile Client] -->|:3000/*| B[fa:fa-server FrontEnd]
    B -->|:3005/*| C[fa:fa-balance-scale Load Balancer]
    C -->|:8080/account| D[fa:fa-server Account]
    C -->|:8080/income| E[fa:fa-server Income]
    C -->|:8080/wallet| F[fa:fa-server Wallet]
    C -->|:8080/mq| I[fa:fa-server Message Queue]
    C -->|:8080/cm| J[fa:fa-server Cloud Messaging]
    D -->|:27017| G[fa:fa-database NoSQL]
    E -->|:27017| G
    F -->|:27017| G
    I -->|:5672 | H[fa:fa-database RabbitMQ]
    J -->|:5672 | K[fa:fa-database Firebase]
```

All Services 

| Service         | Network |   Port |
|-----------------|:-------:|-------:|
| Web             |  Front  |   3001 |
| SwaggerUI       |  Front  |   3002 |
| Load balance    |  Front  |   3005 |
| RabbitMQ        |  Front  |  15672 |
| Income          |  Back   |   3005 |
| Wallet          |  Back   |   3005 |
| Account         |  Back   |   3005 |
| Message Queue   |  Back   |   3005 |
| Cloud Messaging |  Back   |   3005 |
| MongoDB         |  Back   |  27017 |
| RabbitMQ        |  Back   |   5672 |

## Backend
- [x] [Income](app/backend/income)  - Microsserviço responsável pela parte de rendimentos
- [x] [Wallet](app/backend/wallet)   - Microsserviço responsável pela parte de carteiras
- [ ] [Account](app/backend/account)  - Contains methods to access the user account details and the checking account transactions and bills
- [ ] [Auth](app/backend/auth)     - Authentication operations
- [ ] [Card](app/backend/card)     - Contains methods to retrieve the feed of transactions from the credit card
- [ ] [Payment](app/backend/payment)  - Contains methods to create payment requests
- [ ] [MQ](app/backend/mq)  - Message Queue with RabbitMQ
- [ ] [CM](app/backend/cm)  - Cloud Messaging with Firebase for push notifications

## How to run

1. [Compose](COMPOSE.md)
2. [K8S](K8S.md)
3. [Helm](HELM.md)

### Ref

* [mermaid-editor](https://mermaidjs.github.io/mermaid-live-editor)
* [spring-boot-banner-generator](https://springhow.com/spring-boot-banner-generator/)
* [kompose](https://kompose.io/)
