FROM openjdk:8-jdk
ADD target/spring-boot-websocket-0.1.0.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]
EXPOSE 8080