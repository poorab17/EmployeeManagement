# EmployeeManagement(updated form of EmpManagement)
 an application with CRUD operations using JSP, Servlet, JDBC, MySQL and Server TomCat



# EmpManagement
 an application with CRUD operations using JSP, Servlet, JDBC, MySQL

 -Create a dynamic web project in Eclipse IDE and name the test project as test (or any desired name).
 
 -Use tomcat server version 10.1 use this link to download and add it to your project https://tomcat.apache.org/
 
 download mysql workbench  https://dev.mysql.com/downloads/workbench/
 
@.inside /test/src/main/webapp

1.Create jsp file named

/test/src/main/webapp/comment.jsp

/test/src/main/webapp/Error.jsp

/test/src/main/webapp/index.jsp

/test/src/main/webapp/login.jsp

/test/src/main/webapp/registration.jsp

/test/src/main/webapp/user-list.jsp

2. Create CSS file
   /test/src/main/webapp/css/style.css

@.inside /test/src/main/webapp/WEB-INF/lib

include the required library from mvn repository

jakarta.servlet.jsp.jstl-2.0.0.jar

jakarta.servlet.jsp.jstl-api-3.0.0.jar

jbcrypt-0.4.jar

jsp-api-2.2.jar

mysql-connector-java-8.0.11.jar

servlet-api-2.5.jar
 
@. inside /test/src/main/java 

1.create package named as 

com.sts.registration :-inside this package create java class Login.java and RegistrationServlet.java 

/test/src/main/java/com/sts/registration/Login.java,RegistrationServlet.java 

com.sts.um.bean   :-inside this package create java class     /test/src/main/java/com/sts/um/bean/UserBean.java  /test/src/main/java/com/sts/um/bean/UserDataUtils.java

com.sts.um.dao    :-inside this package create java class     /test/src/main/java/com/sts/um/dao/UserDao.java

com.sts.um.web    :-inside this package create java class     /test/src/main/java/com/sts/um/web/UserServlet.java
