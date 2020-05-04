FROM tomcat:latest
MAINTAINER "sohelsheikh91@gmail.com"
COPY target/docker-spring-boot.war /usr/local/tomcat/webapps/