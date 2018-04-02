FROM openjdk:8-jdk-alpine

LABEL name="config-demo"

VOLUME /tmp
EXPOSE 8080

ARG JAR_FILE
ADD ${JAR_FILE} app.jar

HEALTHCHECK --interval=15s --timeout=5s CMD nc -z localhost 8080 || exit 1

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
