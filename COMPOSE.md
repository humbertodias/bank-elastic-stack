# Docker compose

```
docker compose up -d
```

Then access 

http://localhost:3001

SwaggerUI

http://localhost:3002


Scale 

```
docker compose up --scale account=2 --scale wallet=3 --scale income=4 -d
```


Stop

```
docker compose down
```