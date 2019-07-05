FROM openjdk:8
ADD customer_ws-0.0.1-SNAPSHOT.jar customer_ws.jar
RUN bash -c 'touch /customer_ws.jar'
ENTRYPOINT ["java", "-jar", "customer_ws.jar"]