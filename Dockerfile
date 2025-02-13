# Fase de construcción (Build stage)
FROM gradle:8-jdk21 AS build
WORKDIR /app

# Instalar dependencias necesarias para la compilación
RUN apt-get update && apt-get install -y git wget

# Copiar el código fuente al contenedor
COPY . .

# Dar permisos de ejecución al archivo gradlew
RUN chmod +x ./gradlew

# Ejecutar Gradle para generar el archivo .jar
RUN ./gradlew bootJar --no-daemon

# Fase de ejecución (Run stage)
FROM openjdk:21-slim
WORKDIR /app

# Exponer el puerto donde corre la aplicación
EXPOSE 8087

# Copiar el archivo .jar generado desde la fase de construcción
COPY --from=build /app/build/libs/proyecto1-0.0.1-SNAPSHOT.jar app.jar

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
