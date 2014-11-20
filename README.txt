		This is sample GWT application
It shows basics of GWT progect configuration and using of GXT widgets.
Also it shows how to use GWT UiBinder to draw user interface and split
application logic from user interface.

Spring Security Framework was used to secure application. Security is
disabled by default. To enable security uncomment marked line in file
applicationContext.xml

To run application use maven command to package and deploy application:
	mvn package jetty:deploy-war
Application will available by http://localhost:8080/SuperClient/gwt.html