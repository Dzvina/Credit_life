FROM openjdk:8
ADD credit_ws-0.0.1-SNAPSHOT.jar credit_ws.jar
RUN bash -c 'touch /credit_ws.jar'
ENTRYPOINT ["java", "-jar", "credit_ws.jar"]