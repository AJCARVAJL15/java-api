# FROM openjdk:17-jdk-slim

# WORKDIR /app

# COPY target/*.jar app.jar

# EXPOSE 8081

# CMD ["java", "-jar", "app.jar"]

# Etapa 1: Compilar el proyecto
FROM maven:3-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Etapa 2: Ejecutar la aplicación
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]