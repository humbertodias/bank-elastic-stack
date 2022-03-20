# Docker compose

```
docker compose up -d
```

or

```
docker compose up -f docker-compose-dev.yml -d
```

Then access 

http://localhost:3001

SwaggerUI

http://localhost:3002


Scale 

```
docker compose up -d --scale account=2 --scale wallet=3 --scale income=4 
```


Stop

```
docker compose down
```