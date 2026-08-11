# GuessNumberServer 🐋☕🍃🐘
A spring boot server for the numberguessing game

<p float="left">
  <img src="https://github.com/Ztirom45/GuessNumberServer/blob/main/rsc/2.png" width="49%" />
  <img src="https://github.com/Ztirom45/GuessNumberServer/blob/main/rsc/1.png" width="49%" />
</p>


## Use:
### install with docker compose 🐋⇩
#### tested on (Fedora 41 x86)
- [download install_and_run_compose.yaml](https://raw.githubusercontent.com/Ztirom45/GuessNumberServer/refs/heads/release/compose.yaml)
- or use `wget https://raw.githubusercontent.com/Ztirom45/GuessNumberServer/refs/heads/release/install_and_run_compose.yaml`
- or use `curl -O https://raw.githubusercontent.com/Ztirom45/GuessNumberServer/refs/heads/release/install_and_run_compose.yaml`
- run `docker compose -f install_and_run_compose.yaml up`
- you may need to use `sudo`
- you may need to start docker `sudo systemctl start docker`
- if it throws errors after first boot up: try to rerun it

### build yourself 🐋 🏗:
#### tested on: (Fedora 41 x86) (raspberry pi os arm)
```
git clone https://github.com/Ztirom45/GuessNumberServer
cd GuessNumberServer
./gradlew bootJar
docker compose build
docker compose up
```
- you may need to use `sudo`
- you may need to start docker `sudo systemctl start docker`

### run jar directly on your system (not recommended)
```
git clone https://github.com/Ztirom45/GuessNumberServer
cd GuessNumberServer
./gradlew bootJar
```
- replace in application properties `spring.datasource.url=jdbc:postgresql://localhost:5432/db`
```
docker compose up postgres
```
- you may need to use `sudo`
- you may need to start docker `sudo systemctl start docker`



### frontend 🖥️:
- http://localhost:8080

### guess API 🖧: 
- range: 
    ```java
    float GUESS = (float)(ThreadLocalRandom.current().nextInt(-0x7fffffff,0x7fffffff))/10000.f;
    ```
- http://localhost:8080/greeting?number= `GUESS`
- example: http://localhost:8080/greeting?number=-11.12
### highscore API 🖧:
- `float time`
- `int tries`
- add a score: [http://localhost:8080/score?tries=](_)`tries`[&time=](_)`time`
- read scores: http://localhost:8080/get_scores

## used technologies
### backend 🖧:
- 🍃spring boot
- 🐘postgres / h2 in the past
### frontend 🖥️:
- html css javascript
- ≈tailwind + daisyUI
### deployment
- 🐋docker-compose
