FROM openjdk:11
EXPOSE 8080
ADD target/springboot-crud-restful-webservices-0.0.1-SNAPSHOT.jar tweetAppService.jar
ENTRYPOINT ["java","-jar","/tweetAppService.jar"]