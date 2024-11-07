FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /workspace/app

COPY . /workspace/app

RUN chmod +x ./gradlew
RUN --mount=type=cache,target=/root/.gradle ./gradlew clean bootJar
RUN mkdir -p build/dependency && (cd build/dependency; jar -xf ../libs/*-SNAPSHOT.jar)

FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=/workspace/app/build/dependency
COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

ENTRYPOINT ["java","-cp","app:app/lib/*","org.crews.CrewsApplication"]


# FROM ubuntu:22.04 as builder
# COPY gradlew .
# COPY gradle gradle
# COPY build.gradle .
# COPY settings.gradle .
# COPY src src
# RUN apt-get update
# RUN apt-get install -y openjdk-17-jre openjdk-17-jdk-headless
# RUN apt-get install -y dos2unix
# RUN dos2unix ./gradlew
# RUN chmod +x ./gradlew
# RUN ./gradlew clean build

# FROM openjdk:17-jdk-alpine
# COPY --from=builder build/libs/*.jar /home/server.jar
# ENTRYPOINT ["java", "-jar", "/home/server.jar", "--spring.profiles.active=dev"]
