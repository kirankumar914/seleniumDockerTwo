FROM openjdk:8u191-alpine3.8

RUN apk add curl jq

WORKDIR usr/share/DockersTest

ADD target/selenium-docker.jar         selenium-docker.jar
ADD target/selenium-docker-tests.jar   selenium-docker-tests.jar
ADD target/libs                        libs

ADD flight-module.xml                  flight-module.xml
ADD search-module.xml                  search-module.xml
RUN wget https://s3.amazonaws.com/selenium-docker/healthcheck/healthcheck.sh

ENTRYPOINT sh healthcheck.sh