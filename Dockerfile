FROM eclipse-temurin:23-jdk
ARG APP_NAME=notifications
ARG VERSION=1.0
RUN mkdir ${APP_NAME}
WORKDIR /${APP_NAME}

ARG JAR_FILE=${APP_NAME}-${VERSION}.jar

RUN mkdir "application"
COPY target/${JAR_FILE} ./application/${JAR_FILE}
COPY src/main/resources/logback-spring.xml ./application/logback-spring.xml
COPY src/main/resources/templates ./application
EXPOSE 8080

# Create a script to pass command line args to entrypoint
RUN echo "java -jar ./application/$JAR_FILE \$@" > ./application/run_application.sh

ENTRYPOINT ["/bin/bash","./application/run_application.sh"]
