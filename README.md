# GuessNumberServer
A spring boot server for the numberguessing game

## Use:
### install with docker compose
- [download install_and_run_compose.yaml](https://github.com/Ztirom45/GuessNumberServer/blob/release/install_and_run_compose.yaml)
- run `sudo docker compose -f install_and_run_compose.yaml up`

### frontend:
- http://localhost:8080


### json API 
- range: 
    ```java
    float GUESS = (float)(ThreadLocalRandom.current().nextInt(-0x7fffffff,0x7fffffff))/10000.f;
    ```
- http://localhost:8080/greeting?number= `GUESS`
- example: http://localhost:8080/greeting?number=-11.12
### highscore api:
- `int time`
- `float tries`
- add a score: http://localhost:8080/score?tries=`tries`&time=`time`
- read scores: http://localhost:8080/get_scores

