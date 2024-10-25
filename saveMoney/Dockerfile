# First stage: use Maven with Java 11 to build the application
FROM maven:3.8.6-openjdk-11 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven configuration files and source code
COPY pom.xml .
COPY src ./src

# Build the Spring Boot application
RUN mvn clean package -DskipTests

# Second stage: use Java 11 for running the app
FROM openjdk:11-jdk-slim

# Set the working directory inside the container for the second stage
WORKDIR /app

# Copy the JAR file from the previous build stage
COPY --from=build /app/target/application-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your Spring Boot application uses
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
