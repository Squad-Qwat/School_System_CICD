# Stage 1: Build JAR

FROM maven:3.9-eclipse-temurin-21-alpine AS builder
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline -q
COPY src ./src
RUN mvn package -DskipTests -q

# Stage 2: Runtime with ttyd (terminal via web browser)
FROM eclipse-temurin:21-jre-alpine

# Install ttyd + dependencies
RUN apk add --no-cache ttyd tini

WORKDIR /app
COPY --from=builder /build/target/Aktivitas-1.0-SNAPSHOT.jar app.jar

# ttyd wraps the java app and serves it as a web terminal
# --writable  : allows keyboard input (required for interactive TUI)
# --once      : auto-restart handled by Docker, not ttyd (see restart policy)
# port 7681   : ttyd default, only exposed inside Docker network
EXPOSE 7681

# tini as init to properly handle signals and zombie processes
ENTRYPOINT ["/sbin/tini", "--"]
CMD ["ttyd", "--writable", "--port", "7681", "java", "-jar", "/app/app.jar"]
