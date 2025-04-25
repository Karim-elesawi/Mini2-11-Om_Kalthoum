FROM eclipse-temurin:23-jdk-alpine

WORKDIR /app

# Copy Maven build output to container
COPY target/*.jar app.jar

EXPOSE 6391

ENTRYPOINT ["java", "-jar", "app.jar"]