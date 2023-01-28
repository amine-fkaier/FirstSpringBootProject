FROM fundingsocietiesdocker/openjdk19-alpine
EXPOSE 8080
ARG APP_NAME="FirstProject"
ARG APP_VERSION="0.0.1"
ARG JAR_FILE="/target/${APP_NAME}-${APP_VERSION}-SNAPSHOT.jar"

COPY ${JAR_FILE} app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]