# Chameleon

Chameleon is a JDBC implementation that uses UcanAccess library in order to execute SQL statements in an MS-Access database. It can be extended to use any JDBC driver.

## Developers notes

If you want to debug the jar file, you can run the application using these parameters:
`java -Xdebug -Xrunjdwp:transport=dt_socket,address=8000,server=y,suspend=y -jar chameleon-1.0.jar`