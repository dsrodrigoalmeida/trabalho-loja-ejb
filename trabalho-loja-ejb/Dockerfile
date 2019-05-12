FROM adoptopenjdk/openjdk11:alpine as build
WORKDIR /home/rodrigo/trabalho-loja-ejb/


COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY ear ear
COPY ejb ejb
COPY web web
COPY ear-reposicao ear-reposicao
COPY ejb-reposicao ejb-reposicao
COPY web-reposicao web-reposicao


RUN ./mvnw install -DskipTests


FROM michelav/wildfly-alpine

WORKDIR /home/rodrigo/Application Servers/wildfly15/standalone/deployments/ear-1.0.ear

ARG DEPENDENCY=/home/rodrigo/trabalho-loja-ejb

COPY --from=build ${DEPENDENCY}/ear/target/ear-1.0.ear .

CMD ["/home/rodrigo/Application Servers/wildfly15/bin/standalone.sh", "-b", "0.0.0.0", "-c", "standalone-full.xml", "-bmanagement", "0.0.0.0"]


FROM michelav/wildfly-alpine

WORKDIR /home/rodrigo/Application Servers/wildfly16/standalone/deployments/ear-reposicao-1.0.ear

ARG DEPENDENCY=/home/rodrigo/trabalho-loja-ejb

COPY --from=build ${DEPENDENCY}/ear/target/ear-reposicao-1.0.ear .


CMD ["/home/rodrigo/Application Servers/wildfly15/bin/standalone.sh", "-b", "0.0.0.0", "-c", "standalone-full.xml", "-bmanagement", "0.0.0.0"]
