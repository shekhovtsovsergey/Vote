FROM gradle:7.2.0-jdk11 AS build
COPY . /app
WORKDIR /app
RUN gradle build --no-daemon --stacktrace
RUN ls -al
FROM openjdk:11-jre-slim
COPY --from=build /app/build/libs/*.jar /app/app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]