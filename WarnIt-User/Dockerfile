FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/WarnIt-User.jar WarnIt-User.jar
EXPOSE 8200
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/WarnIt-User.jar", "user-service"]

