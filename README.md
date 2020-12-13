# Daddy-sCoffeeShop Online Order Application

This is an Android Application for a coffee shop to order coffee online. 
#### Device requirements To run the Daddy's Coffee project, your device must meet the following requirements:
* Android API level 22 or newer

#### Prerequisites To use the Daddy's Coffee for Android, you need the following:

* The latest version of Android Studio.
* the Gradle build automation system version 2.2.1 or later.
* Java Development Kit (JDK) 7.
* The application must have the Internet Permission.

### Prerequisites To use the Daddy's Coffee for REST API, you need the following:
* Spring Tool Suite(STS)
* MYSQL 

### Configure the  project

1. To connect the Spring Boot application to the database,need to provide the server port, database URL, username, and password to the application.
To do this, simply create a file application.properties inside the resources folder and paste the code below into it:

- server.port=8081 //Check your localhost server port
- spring.datasource.url=jdbc:mysql://localhost:Your_PORT/daddyscoffee
- spring.datasource.username=root
- spring.datasource.password=YOUR_PASSWORD

2. Restore the database Backup

2. Run the web project.

3. change the ip addreess of BASE_URL in Android Studio. 
To do this simply create a file application.properties inside the resources folder and paste the code below into it:

 -  public static final String BASE_URL = "http://your_IP:your_localhost_server_port/product/";
  
4.Run the Android Application
