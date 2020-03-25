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

# teoria
* serwer - maszyna
* web serwer/serwer aplikacyjny - software na serwerze nasluchujacy zadan klientow
* web servery obsluguja specyficzne 'jary' - pliki war - web archive
* wary trzeba dostosowac do pracy z aplikacja

## WAR
* html. cee, jpegi - static content. W roocie paczki
* /WEB-INF - folder z web information. Serwer aplikacyjny zapewnia, ze klient nie ma dostepu tutaj
    * /classes
    * /lib
    * web.xml - konfiguracja aplikacji
*  /META-INFO - info o warze. Dla jarow jest ciekawe, dla warow niespecjalnie. klasy i inne metadane
    * manifest - plil z danymi, wersja wara, ile plikow w srodku etc.
    
wara budujemy np. mavenem

deploy - stawiamy serwer, kopiujemy wara do /webaps w webserwerze. Tomcat wykryje i zaladuje

## po co nam to?
dynamicznie generowane htmle, zamiast statyczne. kazdy request generuje kontent,

servlet - klasa javowa do obslugi zadan http, dziala w web apliakcji na serwerze aplikacyjnym  
    