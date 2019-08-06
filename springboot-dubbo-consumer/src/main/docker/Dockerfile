FROM openjdk:8-jre

MAINTAINER Lusifer <1042620949@qq.com>

ENV APP_VERSION 1.1.0-SNAPSHOT
ENV DOCKERIZE_VERSION v0.6.1

RUN mkdir /app

COPY target/*.jar  /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/app.jar"]
