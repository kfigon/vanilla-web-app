# Making a web app without any framework using pure java

# required
java 8, docker

# build
mvn clean install to create war

## start tomcat, copy war:
* `docker build -t mywebapp .`
* `docker run -p 8080:8080 mywebapp` or with `-d`

or use embedded tomcat (mvn dependency)

test with: `http://localhost:8080/vanilla-web-app-1.0.0-SNAPSHOT/hello.html`