FROM eclipse-temurin:17

LABEL maintainer="rmramalepe21@gmail.com"

WORKDIR /app

COPY target/employeemanagementbackend-0.0.1-SNAPSHOT.jar /app/employeemanagementbackend.jar

ENTRYPOINT ["java", "-jar", "employeemanagementbackend.jar"]