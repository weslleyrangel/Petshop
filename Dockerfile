
FROM maven:3.8.1-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/petshop-1.0-SNAPSHOT.jar petshop.jar

CMD ["java", "-jar", "petshop.jar"]