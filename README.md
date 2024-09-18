# Employee-Details-and-Tax-Deduction-Project
I opened spring initializer website 
choosen required confugiration and dependencies for the project.
Then downloaded the project and imported into STS IDE
I created required packages like entity,RestController,Service and repository
Then created the required classes and configured required annotations in all classes
created the save employee and taxdeduction rest endpoints with post and get methods
Then created two seperate service classes for save employee and tax deduction service classes
I wrote a main business logic in the required service classes
I created one user interface and extended with jpa repository for the database connection
For the save employee rest end point I am using the save method in the JPA repository
For the Taxdeduction rest end point I am using the findByEmployeeId method in the JPA repository
For the Db connection currently  I have configured H2 db in the application.properties file
I changed the default port number 8080 into 8081 using server.port property in the application.properties file
Handled all the required validations and http status codes
I tested the rest endpoints using the postman tool
Then i uploaded the project into github by selecting and droppping files into github repository as i encountered issue with pushing project into Github from IDE.
