FROM gradle:8-jdk21 AS build

COPY build/libs/proyecto1-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]