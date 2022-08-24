# Introduction
(50-100 words)
What does this app do? What technoglies your have used?

CustomerDAO (data access object) which performs CRUD operations on customer table of hplussport database stored in docker psql instance. also contains a database connection Manager class to connect to JDBC URL whcih contains the database and host and username and password.
Technologies used are JDBC to manipulate data in database using CRUD operations and Customer objects, PSQL to acess database, MVN, Docker, intelliji and git/ github.

# Implementaiton
## ER Diagram
![my image](../assets/ER-diagram.JPG)

## Design Patterns
Discuss DAO and Repository design patterns (150-200 words)

DAO is a Data Access Object and is a class that uses CRUD operations on an object in the project. an object can be one row in the database table (for instance a customer object attributes (columns)) or an object can be the result of a query.
a DTO is a Data Transfer Object and it is a model or java object in the DAO (for instance in this project we used a Customer Object as our DTO).
when we create a DTO ( new customer object) we add it to the databasse via the DAO (CustomerDAO). Similarly if we want to delete a DTO we delete it via DAO.


# Test
How you test your app against the database? (e.g. database setup, test data set up, query result)

Since we used Lynda course on JDBC to follow along the implementaion of this project, I followed along with the testing implementation, which consisted of testing being done on JDBCExecutor class. a connection was opened using the DatabaseConnectionManager.
