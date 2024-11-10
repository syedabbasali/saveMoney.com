# Stage 1: Build Stage
FROM maven:3.8.6-openjdk-11-slim AS builder

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (optional optimization step)
COPY pom.xml ./
RUN mvn dependency:go-offline

# Copy the rest of the application source code and compile it
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Runtime Stage (smaller image)
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the builder stage
COPY --from=builder /app/target/application-0.0.1-SNAPSHOT.jar /app/application.jar

# Expose the port your application will run on (change to match your app’s configuration)
EXPOSE 8080

# Command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "/app/application.jar"]
