FROM openjdk:17
WORKDIR /app
COPY target/api-odo-0.0.1-SNAPSHOT.jar /app/api-odo.jar
ENTRYPOINT [ "java", "-jar", "/app/api-odo.jar" ]