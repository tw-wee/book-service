FROM frolvlad/alpine-oraclejdk8:slim
VOLUME /tmp
ADD book-api-0.1.0.jar book-app.jar
RUN sh -c 'touch /book-app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/book-app.jar"]