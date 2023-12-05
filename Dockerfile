# Build Phase
FROM openjdk:21-bookworm as builder

WORKDIR /app

# Copy only the Gradle files first to leverage Docker cache
COPY build.gradle settings.gradle gradlew /app/
COPY gradle /app/gradle

# Download the dependencies and generate the wrapper
RUN ./gradlew --version

# Copy the rest of the application code
COPY src /app/src

# Build the application
RUN ./gradlew clean build

# Run Phase
FROM openjdk:21

# create user 1000 to run the application
RUN groupadd -g 1000 appgroup && useradd -u 1000 -g 1000 appuser
WORKDIR /app

# Copy the JAR file from the build phase
COPY --from=builder --chown=appuser:appuser /app/build/libs/cookiestore-0.0.1-SNAPSHOT.jar /app/

USER appuser
# Set the default command to run the application
CMD ["java", "-jar", "cookiestore-0.0.1-SNAPSHOT.jar"]
