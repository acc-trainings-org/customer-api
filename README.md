# customer-api

#### **`POM`**
Update [POM](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html#:~:text=A%20Project%20Object%20Model%20or,default%20values%20for%20most%20projects.) as following
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.4.1</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>
	<groupId>com.acc.training</groupId>
	<artifactId>customer-api</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>customer-api</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>11</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springdoc</groupId>
			<artifactId>springdoc-openapi-ui</artifactId>
			<version>1.5.2</version>
		</dependency>
 </dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<!-- This 2019 version is required for OpenAPI 3 -->
				<groupId>io.swagger.codegen.v3</groupId>
				<artifactId>swagger-codegen-maven-plugin</artifactId>
				<version>3.0.24</version>
				<executions>
					<execution>
						<goals>
							<goal>generate</goal>
						</goals>
						<configuration>
							<inputSpec>${project.basedir}/src/main/resources/customer-api.yml</inputSpec>
							<language>spring</language>
							<output>${project.build.directory}/generated-sources/</output>
							<generateSupportingFiles>false</generateSupportingFiles>
							<modelPackage>com.acc.training.customerapi.model</modelPackage>
							<apiPackage>com.acc.training.customerapi.api</apiPackage>
							<configOptions>
								<interfaceOnly>true</interfaceOnly>
							</configOptions>
						</configuration>
					</execution>
				</executions>
			</plugin>
			<plugin>
				<groupId>org.codehaus.mojo</groupId>
				<artifactId>build-helper-maven-plugin</artifactId>
				<version>3.2.0</version>
				<executions>
					<execution>
						<id>add-source</id>
						<phase>generate-sources</phase>
						<goals>
							<goal>add-source</goal>
						</goals>
						<configuration>
							<sources>
								<source>${project.build.directory}/generated-sources/src/main/java</source>
							</sources>
						</configuration>
					</execution>
				</executions>
			</plugin>
		</plugins>
	</build>
</project>
```

### Window User OpenShift CLI Setup
* Go to https://console-openshift-console.apps.awsopenshift.ne-innovation.com and login with oktaidp
* Create your account using Accenture ID and Sign in to the application
* Click on the ? Icon and select Command Line Tools
* Download the oc CLI as per your OS and extract the zipped file to a directory
* Set path environment variables 

### OpenShift CLI Deployment
* Login to OpenShift [OC Login](https://oauth-openshift.apps.awsopenshift.ne-innovation.com/oauth/authorize?client_id=console&redirect_uri=https%3A%2F%2Fconsole-openshift-console.apps.awsopenshift.ne-innovation.com%2Fauth%2Fcallback&response_type=code&scope=user%3Afull&state=89ae6812)
* Copy login command (Top right click on ? mark and then select Command Line Tool) and then after click on Copy Login Command.
* Open Command Line or Terminal and paste the login command.
* ***Frequently used OC commands***

   1. `oc version` - Check OC CLI Version
   2. `oc status` - Check the status
   3. `oc projects` - To see available projects
   4. `oc new-project acctrainings-firstName` - Create new project. Replace firstName with your name.
   5. `oc projects` - check again the project whether it's created
   6. `oc new-app fabric8/s2i-java:latest-java11~https://github.com/acc-trainings-org/customer-api.git#customer-api-rahul --name=customer-api-rahul` - Create new app under your project.
   7. `oc get services` - To get services
   8. `oc get pods` - To check created pods
   9. `oc get routes` - See available routes for your service.
   10. `oc expose svc/customer-api` - Expose/create route for your application.
   11. `oc get route` - This will give you route to access your deployed application.
   12. `http://copyYourUrl/rahul/customer-api/swagger-ui.html` copy your url and add and hit on the browser.
   13. `oc get pods` - Get the pod name
   14. `oc logs pod enterYourPodName` - To check logs
   15. `oc delete all --selector app=customer-api` - Delete deployment.

