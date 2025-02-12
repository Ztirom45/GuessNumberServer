# Use:
## json 
- `float GUESS = (float)(ThreadLocalRandom.current().nextInt(-0x7fffffff,0x7fffffff))/10000.f;`
- http://localhost:8080/greeting?number=<GUESS>
- example: http://localhost:8080/greeting?number=-11.12

## h2
- http://localhost:8080/h2-console/
- JDBC Url: jdbc:h2:mem:dcbapp
