FROM maven:3-jdk-11 as BUILDER

WORKDIR /workspace

COPY pom.xml .

RUN mvn dependency:go-offline

COPY src src/

RUN mvn clean package -Dmaven.test.skip=true

###

FROM adoptopenjdk:11-jdk-hotspot

EXPOSE 8080

COPY --from=BUILDER /workspace/target/*.jar /usr/app/app.jar

ENTRYPOINT ["java", "-jar", "/usr/app/app.jar"]
