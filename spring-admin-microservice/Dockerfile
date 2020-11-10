FROM maven:3.6.3-openjdk-11-slim as build
WORKDIR /opt
COPY . .
WORKDIR /opt/bologna-admin
RUN mvn clean install


FROM openjdk:11-jre
RUN mkdir /opt/app
COPY --from=build /opt/bologna-admin/target/admin-microservice-executable.jar /opt/app/server.jar
CMD ["java", "-jar", "/opt/app/server.jar"]
