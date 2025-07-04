# ------------ Stage 1: Build WAR using Maven ------------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy your entire project
COPY . .

# Build the WAR file
RUN mvn clean package -DskipTests


# ------------ Stage 2: Deploy to Tomcat ------------
FROM tomcat:9.0

# Remove default Tomcat apps (optional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy WAR from previous stage into ROOT.war
COPY --from=build /app/target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080

