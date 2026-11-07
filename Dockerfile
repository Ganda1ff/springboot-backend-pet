# Use Maven to build the application
FROM maven:4.0.0-rc-7-eclipse-temurin-21 AS build

# Set the working directory for the build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Build the application
RUN mvn clean package -DskipTests

# Use a minimal Java runtime for the final image
FROM eclipse-temurin:21-jre AS final

# The application's jar file
ARG JAR_FILE=target/music-0.0.1-SNAPSHOT.jar

# Copy the jar file from the build stage to the final image
COPY --from=build /app/${JAR_FILE} app.jar

EXPOSE 8080 

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]