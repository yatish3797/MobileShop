FROM openjdk:8
EXPOSE 8080
ADD target/mobile-online-store.jar mobile-online-store.jar
ENTRYPOINT ["java","-jar","mobile-online-store.jar"]