FROM openjdk:17
COPY /target/countries-0.0.1-SNAPSHOT.jar countries-0.0.1-SNAPSHOT.jar
ENV DB_ADDRESS=mysql
ENV DB_USERNAME=root
ENV DB_PASSWORD=root
ENTRYPOINT ["/usr/bin/java", "-jar", "countries-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080