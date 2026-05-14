# =========================
# 1. Build stage
# =========================
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app

# 1. Copy only pom first (for dependency caching)
COPY pom.xml .

# 2. Download dependencies (cached layer)
RUN mvn dependency:go-offline -B

# 3. Copy source code
COPY src ./src

# 4. Build jar (reuse cached dependencies)
RUN mvn clean package -DskipTests -B


# =========================
# 2. Runtime stage
# =========================
FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

# Better JVM startup tuning
ENTRYPOINT ["java",
  "-XX:+UseG1GC",
  "-XX:MaxRAMPercentage=75.0",
  "-Dspring.profiles.active=prod",
  "-jar",
  "app.jar"]