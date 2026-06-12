FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline -q
COPY src src
RUN ./mvnw package -DskipTests -q

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
RUN apk add --no-cache bash && mkdir -p src/main/resources/uploads
COPY --from=build /app/target/*.jar app.jar
COPY wait-for-db.sh /wait-for-db.sh
RUN chmod +x /wait-for-db.sh
EXPOSE 8080
ENTRYPOINT ["/bin/bash", "/wait-for-db.sh", "java", "-jar", "app.jar"]
