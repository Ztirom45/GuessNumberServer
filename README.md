# GuessNumberServer
A spring boot server for the numberguessing game

## Use:
### json API 
- range: 
    ```java
    float GUESS = (float)(ThreadLocalRandom.current().nextInt(-0x7fffffff,0x7fffffff))/10000.f;
    ```
- http://localhost:8080/greeting?number= `GUESS`
- example: http://localhost:8080/greeting?number=-11.12

### h2 database for logging
- http://localhost:8080/h2-console/
- JDBC Url: jdbc:h2:mem:dcbapp
- read log:
```sql
SELECT * FROM LOGGING_ENTITY 
```

### install and run with docker
```sh
docker pull ghcr.io/ztirom45/guess_number_server
docker run -p8080:8080 ghcr.io/ztirom45/guess_number_server
```
