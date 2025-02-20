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
### highscore api:
- TODO: documenteation

### frontend:
- http://localhost:8080

### install with docker compose
- [download install_and_run_compose.yaml](https://github.com/Ztirom45/GuessNumberServer/blob/main/install_and_run_compose.yaml)
- run `sudo docker compose -f install_and_run_compose.yaml up`
