FROM openjdk:17-jdk
VOLUME /tmp

ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
ARG JAR_FILE=build/libs/*.jar
### TODO: Needs to build the application
COPY ${JAR_FILE} app.jar
EXPOSE 9000
CMD ["java", "-jar", "app.jar"]


