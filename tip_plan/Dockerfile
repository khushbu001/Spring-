FROM openjdk
VOLUME /tmp
COPY ./target/PlanManagement-0.0.1-SNAPSHOT.jar /PlanManagement-0.0.1-SNAPSHOT.jar
CMD java $JVM_OPTS -Dspring.profiles.active=MY_PROPERTY_FILE -jar /PlanManagement-0.0.1-SNAPSHOT.jar
