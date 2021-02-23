FROM registry.access.redhat.com/openjdk/openjdk-11-rhel7
# Create app directory
WORKDIR /opt/app

#RUN mvn clean install package

# Refer to Maven build -> finalName
ARG JAR_FILE=target/customer-service-0.0.1-SNAPSHOT.jar

# cp target/customer-service-0.0.1-SNAPSHOT.jar /opt/app/app.jar
COPY ${JAR_FILE} customer-service.jar

EXPOSE 8080
CMD ["java","-jar","customer-service.jar"]
