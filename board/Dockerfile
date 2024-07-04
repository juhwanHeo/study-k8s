FROM amazoncorretto:17-alpine AS builder

WORKDIR /app
COPY ./ ./

## build
RUN chmod +x ./gradlew
RUN ./gradlew clean build

FROM amazoncorretto:17-alpine
COPY --from=builder /app/build/libs/*.jar app.jar

## application entrypoint
ENTRYPOINT ["java", "-jar", "app.jar"]
