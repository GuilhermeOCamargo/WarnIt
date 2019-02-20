FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/WarnIt-Eureka.jar WarnIt-Eureka.jar
EXPOSE 8761
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/WarnIt-Eureka.jar", "eureka"]

