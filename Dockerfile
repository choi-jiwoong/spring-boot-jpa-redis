FROM amazoncorretto:20 AS build

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJar


FROM amazoncorretto:20
COPY --from=build build/libs/*.jar app.jar
ENV	USE_PROFILE local

ENTRYPOINT ["java", "-jar", "app.jar"]