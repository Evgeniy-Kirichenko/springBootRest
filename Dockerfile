FROM openjdk:8-jdk-alpine
ADD target/springBootRest-1.0-SNAPSHOT.jar myapp.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/myapp.jar"]