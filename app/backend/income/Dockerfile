FROM gradle:7.4.0-jdk11-alpine AS build
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false -Dorg.gradle.workers.max=2"
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon --parallel --build-cache

FROM openjdk:11-jre-slim AS runtime
EXPOSE 8080
ARG APP_VERSION=0.0.1-SNAPSHOT
RUN apt update && apt install curl jq -y
HEALTHCHECK --start-period=30s --interval=30s --timeout=3s --retries=3 \
            CMD curl --silent --fail --request GET http://localhost:8080/actuator/health \
                | jq --exit-status -n 'inputs | if has("status") then .status=="UP" else false end' > /dev/null || exit 1

RUN mkdir /app
COPY --from=build /home/gradle/src/build/libs/income-${APP_VERSION}.jar /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
