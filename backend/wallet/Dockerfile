FROM gradle:7.4.0-jdk11-alpine AS build
COPY --chown=gradle:gradle . /home/gradle/src
WORKDIR /home/gradle/src
RUN gradle build --no-daemon 

FROM openjdk:11-jre-slim
EXPOSE 8080
RUN mkdir /app
RUN apt update && apt install curl jq -y
COPY --from=build /home/gradle/src/build/libs/wallet-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/app.jar"]
HEALTHCHECK --start-period=30s --interval=30s --timeout=3s --retries=3 \
            CMD curl --silent --fail --request GET http://localhost:8080/actuator/health \
                | jq --exit-status -n 'inputs | if has("status") then .status=="UP" else false end' > /dev/null || exit 1