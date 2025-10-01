# Use Java 21 base image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy the packaged JAR into the container
COPY target/Spring-Boot-REST-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
