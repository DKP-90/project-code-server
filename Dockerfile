FROM openjdk:8
ADD target/project-code-server.jar project-code-server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","project-code-server.jar"]