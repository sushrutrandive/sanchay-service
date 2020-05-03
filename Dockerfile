FROM maven:3.5.2-jdk-8-alpine AS MAVEN_BUILD
MAINTAINER Sushrut Randive
COPY pom.xml /build/
COPY src /build/src/
WORKDIR /build/
RUN mvn -DskipTests package
FROM openjdk:8-jre-alpine
WORKDIR /app
EXPOSE 8080
COPY --from=MAVEN_BUILD /build/target/sanchay-service-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-jar", "sanchay-service-0.0.1-SNAPSHOT.jar"]