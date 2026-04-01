
FROM maven:3.9.14-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
RUN addgroup appgroup
RUN adduser -D appuser -G appgroup
RUN chown -R appuser:appgroup /app
USER appuser
EXPOSE 8080
ENTRYPOINT [ "java", "-jar", "app.jar" ]
