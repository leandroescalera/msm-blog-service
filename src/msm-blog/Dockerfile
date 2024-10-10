# Etapa de construcción
FROM maven:3.8.6-openjdk-11 AS build
WORKDIR /app

# Copia los archivos POM para que Maven pueda resolver las dependencias
COPY pom.xml ./
COPY msm-blog-api/pom.xml ./msm-blog-api/
COPY msm-blog-service/pom.xml ./msm-blog-service/
COPY msm-blog-model/pom.xml ./msm-blog-model/

# Copia el código fuente
COPY msm-blog-api/src ./msm-blog-api/src
COPY msm-blog-service/src ./msm-blog-service/src
COPY msm-blog-model/src ./msm-blog-model/src

# Construye el proyecto
RUN mvn clean install -DskipTests

# Etapa de ejecución
FROM openjdk:11-jdk-slim
WORKDIR /app

# Copia el JAR construido
COPY --from=build /app/msm-blog-service/target/msm-blog-service-1.0.0-SNAPSHOT.jar ./msm-blog-service.jar

# Configura el comando de inicio
ENTRYPOINT ["java", "-jar", "msm-blog-service.jar"]
