FROM amazoncorreto:11-alpine-jdk                            //imagen de java
MAINTAINER ezniev                                           //dueño de la imagen java
COPY target/ezniev-0.0.1-SNAPSHOT.jar ezniev-app.jar        //Comando que copia de nuestra el maquina el empaquetado y lo sube
ENTRYPOINT ["java","-jar","/ezniev-app.jar"]                //Indica cual es la instrucción que se va a ejecutar primero
