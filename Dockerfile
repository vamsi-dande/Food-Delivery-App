# Use official Tomcat base image
FROM tomcat:9.0

# Remove default Tomcat apps (optional)
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR into Tomcat's webapps folder
COPY target/*.war /usr/local/tomcat/webapps/ROOT.war

EXPOSE 8080
