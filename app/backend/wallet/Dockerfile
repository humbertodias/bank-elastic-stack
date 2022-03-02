FROM gradle:7.4.0-jdk11-alpine AS build
ENV GRADLE_OPTS="-Dorg.gradle.daemon=false -Dorg.gradle.workers.max=2"
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon --parallel --build-cache

FROM adoptopenjdk/openjdk11:x86_64-alpine-jre-11.0.14.1_1 AS runtime
EXPOSE 8080
ARG APP_VERSION=0.0.1-SNAPSHOT
RUN apk update && apk add curl jq
HEALTHCHECK --start-period=30s --interval=30s --timeout=3s --retries=3 \
            CMD curl --silent --fail --request GET http://localhost:8080/actuator/health \
                | jq --exit-status -n 'inputs | if has("status") then .status=="UP" else false end' > /dev/null || exit 1

WORKDIR /app
COPY --from=build /home/gradle/src/build/libs/wallet-${APP_VERSION}.jar app.jar
ENV JAVA_OPTS="-Xms512m -Xmx1024m"
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]