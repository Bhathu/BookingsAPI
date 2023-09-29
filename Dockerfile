FROM maven:3.9.4 AS build
WORKDIR /usr/local/

COPY src src
COPY pom.xml pom.xml

RUN mvn clean install
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)


FROM openjdk:17-oracle
COPY --from=build /usr/local/target/*.jar BlokGPT-api*.jar
ENTRYPOINT ["java","-jar","/BlokGPT-api*.jar"]