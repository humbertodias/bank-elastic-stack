FROM gradle:jdk11 as cache
RUN mkdir -p /home/gradle/cache_home
ENV GRADLE_USER_HOME /home/gradle/cache_home
COPY build.gradle /home/gradle/java-code/
WORKDIR /home/gradle/java-code
RUN gradle clean build -i --stacktrace

FROM gradle:jdk11 AS build
ENV GRADLE_OPTS=""
COPY --from=cache /home/gradle/cache_home /home/gradle/.gradle
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon --parallel --build-cache

FROM --platform=linux/x86_64 adoptopenjdk/openjdk11:alpine-jre AS runtime

EXPOSE 8080
RUN apk update && apk add curl jq
HEALTHCHECK --start-period=15s --interval=30s --timeout=3s --retries=3 \
            CMD curl --silent --fail --request GET http://localhost:8080/actuator/health \
                | jq --exit-status -n 'inputs | if has("status") then .status=="UP" else false end' > /dev/null || exit 1

WORKDIR /app
ARG APP_VERSION=0.0.1-SNAPSHOT
COPY --from=build /home/gradle/src/build/libs/account-${APP_VERSION}.jar app.jar
ENV JAVA_OPTS="-Xms512m -Xmx1024m"
CMD ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","app.jar"]
