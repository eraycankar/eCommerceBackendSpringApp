FROM openjdk:11 AS build

COPY pom.xml mvnw ./
COPY .mvn .mvn
RUN ./mvnw dependency:resolve

COPY src src
RUN ./mvnw package

FROM openjdk:11
WORKDIR EcommerceBackendApp
COPY --from=build target/*.jar EcommerceBackendApp.jar
ENTRYPOINT ["java", "-jar", "EcommerceBackendApp.jar"]
