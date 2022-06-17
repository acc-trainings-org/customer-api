#mvn commands
FROM maven:3.8-jdk-11-slim AS build

COPY src temp/app/src
COPY pom.xml temp/app
WORKDIR temp/app

RUN mvn clean install

#start with base image
FROM openjdk:11

ARG JAR_FILE=temp/app/target/*.jar

COPY --from=build ${JAR_FILE} api-ecs-demo.jar

ENTRYPOINT ["java", "-jar","/api-ecs-demo.jar"]

