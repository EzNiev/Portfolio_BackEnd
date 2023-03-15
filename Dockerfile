FROM amazoncorretto:8-alpine                           
MAINTAINER ezniev                                           
COPY target/ezniev-0.0.1-SNAPSHOT.jar ezniev-app.jar        
ENTRYPOINT ["java","-jar","/ezniev-app.jar"]                
