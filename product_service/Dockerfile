FROM adoptopenjdk/openjdk11:alpine-jre
COPY target/product_service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "app.jar" ]