# Spring-MVC-CRUD

This is a basic Web Application which displays the employees and their information on which we can perform CRUD operations.

This project is created using Spring Framework. It uses concepts of Spring AOP, JPA/Hibernate and Spring MVC.

The webpage is created with the help of Thymeleaf and using HTML, CSS.

To run the project, first execute the SQL scripts and update their location in the application.properties file inside the resources/application.properties directory. Along with that also update the ID, password to access your database.

After completing the above steps, go into main/java/com.springboot.thymeleaf/ThymeleafApplication.java and run the code.

After that go to your browser and type in "localhost:8080/". This will take you to the home page where you see a table of the existing employeess. Now you can press update, delete or add employee to perform those actions(check the SQL scripts for existing user).

I have also used Spring AOP in the project which means you can see which method was called using which arguments and what output was received from those methods.
