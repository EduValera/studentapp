# Etapa 1: Build
FROM amazoncorretto:17-alpine AS build

WORKDIR /app
COPY . .
RUN ./mvnw clean package -DskipTests

# Etapa 2: Runtime
FROM amazoncorretto:17-alpine-jdk

WORKDIR /app
COPY --from=build /app/target/studentapp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
