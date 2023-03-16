FROM amazoncorretto:8                     
MAINTAINER ezniev                                           
COPY target/ezniev-0.0.1-SNAPSHOT.jar ezniev-app.jar 
EXPOSE 8080       
ENTRYPOINT ["java","-jar","/ezniev-app.jar"]                
