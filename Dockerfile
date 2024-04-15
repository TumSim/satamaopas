#
# Mvn Build
#
FROM maven:3.8.6-eclipse-temurin-17-focal AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Jar Package
#
FROM eclipse-temurin:17-jre-focal
# Copy the JAR file from the target directory to the destination
COPY target/classes/satamahaku-0.0.1-SNAPSHOT.jar /usr/local/lib/satamahaku.jar
EXPOSE 8080
# Specify the correct name of the JAR file in the entrypoint
ENTRYPOINT ["java", "-jar", "/usr/local/lib/satamahaku.jar"]