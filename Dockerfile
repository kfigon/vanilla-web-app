FROM tomcat:9-jdk8
ADD target/vanilla-web-app-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
EXPOSE 8080
CMD ["catalina.sh", "run"]