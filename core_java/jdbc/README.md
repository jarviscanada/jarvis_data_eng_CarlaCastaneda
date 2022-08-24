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



# Test
How you test your app against the database? (e.g. database setup, test data set up, query result)

Since we used Lynda course on JDBC to follow along the implementaion of this project, I followed along with the testing implementation, which consisted of testing being done on JDBCExecutor class. a connection was opened using the DatabaseConnectionManager.
