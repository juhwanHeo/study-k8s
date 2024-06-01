FROM openjdk:17-jdk

## build
CMD ["./gradlew", "clean", "build"]

## copy
ARG JAR_FILE_PATH=build/libs/*.jar
COPY ${JAR_FILE_PATH} app.jar

## application entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
