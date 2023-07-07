#mvn commands
FROM maven:3.8-jdk-11-slim AS build

COPY src temp/app/src
COPY pom.xml temp/app
WORKDIR temp/app

RUN mvn clean install

#start with base image
FROM openjdk:11

ARG JAR_FILE=temp/app/target/*.jar

COPY --from=build ${JAR_FILE} customer-api.jar

ENTRYPOINT ["java", "-jar","/customer-api.jar"]


#AWS_ECR_Login
#aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 481857672493.dkr.ecr.us-east-1.amazonaws.com/

#docker tag customer-api:latest 481857672493.dkr.ecr.us-east-1.amazonaws.com/customer-api-demo
