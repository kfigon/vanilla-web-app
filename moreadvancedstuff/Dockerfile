FROM tomcat:9-jdk8
ADD target/moreadvancedstuff-1.0.0-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war
ADD src/main/resources/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
EXPOSE 8080
CMD ["catalina.sh", "run"]