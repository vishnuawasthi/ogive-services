# Basic application setup steps:-
1. Clone the below git repository 
	git clone https://github.com/vishnuawasthi/ogive-services.git
	
2. Import it into eclipse by using existing maven project import option.

3. once import is done execute below command 
	
	mvn eclipse:eclipse
	
4. In order to build the project use 
	
	mvn clean install 
	
4. To run the ogive-services use below command or right click on projet and choose run option and run it as java 	application or eclipse application.
	Below is the command to run same from command line 
	mvn spring-boot:run
	
5. Once application is up and running you will be able to see swagger ui hosted at 
		
	http://localhost:8090/swagger-ui.html
	
6. Now you can play around it.				

#################################################################################################
# Reference material 

# Spring boot example and configuration 
1. https://howtodoinjava.com/spring-boot-tutorials/

2. HakariCP configuration reference 
  https://www.javadevjournal.com/spring-boot/spring-boot-hikari/
  
  HakariCP configuration properties 
  
  https://github.com/brettwooldridge/HikariCP
# Gmail email settings
	https://support.google.com/mail/answer/7126229?p=BadCredentials&visit_id=637138139811097939-    2332721584&rd=2#cantsignin  
	
# Email Template ref https://www.netkiller.cn/java/spring/boot/velocity.html
	
###################################################################################################  
# Question 1 .  How to check active connection in porstgress ?
    Answer . To check active connection execute below command in post gress 
    
    SELECT * FROM pg_stat_activity;
    
# Question 2. How to kill  connection in postgress sql 

	SELECT Pg_terminate_backend(pid) 
	FROM   pg_stat_activity 
	WHERE 
	  -- don't kill my own connection! 
	  pid <> Pg_backend_pid() 
	  -- don't kill the connections to other databases 
	  AND datname = 'POC_SCHEMA';
  
# Deploying app in external tomcat server 

1. Go to tomcat installation directory and look  below location 
	D:\java softwares\apache-tomcat-8.0.32\conf 
	
2. Open server.xml file under /conf folder and add the below configuration under the <GlobalNamingResources> tag.

<Resource       	      auth="Container"        
						   name="jdbc/ogiveServicesDev"
						   driverClassName="org.postgresql.Driver"
                           maxActive="10"
                           maxIdle="0"
                           maxWait="10000"
                           password="login@123"
                           username="POC_ADMIN"
                           type="javax.sql.DataSource"
                           url="jdbc:postgresql://localhost:5432/POC_SCHEMA" />	

3. open contaxt.xml from same location and add below tag entry


 <ResourceLink 
					name="jdbc/ogiveServices"
					global="jdbc/ogiveServicesDev" 
					auth="Container" 
		            type="javax.sql.DataSource" />
		            
		            
4. Point jndi-location from your application.properties file bu putting below entry 
spring.datasource.jndi-name=java:comp/env/jdbc/ogiveServices

5. Build the application and deploy it into external tomcat as war project and once application is up
it will be running at http://localhost:1100/ogive-services-0.0.1-SNAPSHOT/swagger-ui.html#/

# Transaction Management 

1. Transaction management  example.
   https://dzone.com/articles/spring-boot-transactions-tutorial-understanding-tr
   
2. Hakari CP DataSource Config 

   https://github.com/brettwooldridge/HikariCP#configuration-knobs-baby    

 		            