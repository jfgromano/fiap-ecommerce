FROM maven:3.9.4-amazoncorretto-21 AS maven

WORKDIR /usr/src/app
COPY . /usr/src/app
RUN mvn package -Dmaven.test.skip

FROM amazoncorretto:21.0.0

ARG JAR_FILE=autenticacao-latest.jar

WORKDIR /opt/tech-challenge
COPY --from=maven /usr/src/app/target/${JAR_FILE} .

ENTRYPOINT ["java","-jar","autenticacao-latest.jar"]