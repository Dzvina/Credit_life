FROM openjdk:8
ADD product_ws-0.0.1-SNAPSHOT.jar product_ws.jar
RUN bash -c 'touch /product_ws.jar'
ENTRYPOINT ["java", "-jar", "product_ws.jar"]