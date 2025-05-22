# -------- Stage 1: Build the application --------
FROM maven:3.9.6-eclipse-temurin-17 as builder

# Set working directory inside container
WORKDIR /customer-api

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the Spring Boot app (creates the JAR)
RUN mvn clean package -DskipTests

# -------- Stage 2: Run the application --------
FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /customer-api

# Copy the built JAR from the previous stage
COPY --from=builder /customer-api/target/*.jar customer-api.jar

# Expose the default Spring Boot port
#EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "customer-api.jar"]



#AWS_ECR_Login
#aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin 481857672493.dkr.ecr.us-east-1.amazonaws.com/

#docker tag customer-api:latest 481857672493.dkr.ecr.us-east-1.amazonaws.com/customer-api-demo
