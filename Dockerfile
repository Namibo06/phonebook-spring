FROM openjdk:17-jdk-alpine AS build
RUN apk update && apk add maven
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn -f /app/pom.xml clean install -Dmaven.test.skip

FROM openjdk:17-jdk-alpine
RUN mkdir /app
COPY --from=build /app/target/phonebook-0.0.1-SNAPSHOT.jar /app/app.jar
WORKDIR /app
EXPOSE 8080
CMD ["java", "-jar", "app.jar"]