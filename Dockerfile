# Usa una imagen base de Eclipse Temurin 21 JDK en Alpine
FROM eclipse-temurin:21-jdk-alpine AS build

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia los archivos de Gradle y el código fuente al contenedor
COPY gradle/ gradle/
COPY gradlew gradlew
COPY build.gradle settings.gradle ./

# Da permisos de ejecución al script gradlew
RUN chmod +x gradlew

# Instala Java 21 explícitamente (por si hay problemas con la detección automática)
RUN apk add --no-cache openjdk21

# Ejecuta Gradle para construir el proyecto (sin test para acelerar la construcción)
RUN ./gradlew build -x test

# Imagen final con Eclipse Temurin 21 JDK
FROM eclipse-temurin:21-jdk-alpine

# Establece el directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR construido desde el contenedor anterior
COPY --from=build /app/build/libs/*.jar app.jar

# Expone el puerto 8080 (el predeterminado de Spring Boot)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]