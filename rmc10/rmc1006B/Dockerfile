FROM bellsoft/liberica-openjdk-alpine:17
ADD target/rmc1006B-0.0.1-SNAPSHOT.jar /app.jar
# crea una carpeta nueva en la maquina destino
RUN mkdir h2dbfiles 
ADD h2dbfiles/EmpleadoDB.mv.db /h2dbfiles
ENTRYPOINT ["java", "-jar", "/app.jar"]