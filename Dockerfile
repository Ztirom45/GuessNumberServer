FROM openjdk:17 
CMD ["./gradlew", "clean", "bootJar"]
COPY build/libs/*.jar app.jar
COPY build/libs/*.jar app.jar
COPY build/resources/main/static/ build/resources/main/static/

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar","-web","-webAllowOthers"]
