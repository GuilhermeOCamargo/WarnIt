FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/WarnIt-Address.jar WarnIt-Address.jar
EXPOSE 8100
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/WarnIt-Address.jar", "address"]

