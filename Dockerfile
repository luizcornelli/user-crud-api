FROM eclipse-temurin:17-jdk-alpine

COPY target/user-crud-api-0.0.1-SNAPSHOT.jar app-1.0.0.jar

ENTRYPOINT [ "java", "-jar", "app-1.0.0.jar" ]
