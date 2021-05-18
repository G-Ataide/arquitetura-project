FROM openjdk:11
EXPOSE 8080
ADD project-aero-0.0.1-SNAPSHOT.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar","/spring-boot-docker.jar"]