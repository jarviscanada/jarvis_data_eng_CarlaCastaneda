package ca.jrvs.apps.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCExecutor {

  public static void main(String... args) {

    DatabaseConnectionManager dcm= new DatabaseConnectionManager("localhost", "hplussport","postgres","password");
    try{

      Connection connection =dcm.getConnection();
      CustomerDAO customerDAO = new CustomerDAO(connection);
      Customer customer= customerDAO.findById(10000);
      System.out.println(customer.getFirstName()+" "+ customer.getLastName());
//      Customer customer = new Customer();
//      customer.setFirstName("George");
//      customer.setLastName("Washington");
//      customer.setEmail("george.washington@wh.gov");
//      customer.setPhone("(555) 555-6543");
//      customer.setAddress("1234 Main St");
//      customer.setCity("Mount Vernon");
//      customer.setState("VA");
//      customer.setZipCode("22121");
//
//      customerDAO.create(customer);

//      Statement statement = connection.createStatement();
//      ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) FROM CUSTOMER");
//      while (resultSet.next()){
//        System.out.println(resultSet.getInt(1));
//      }
    }catch (SQLException e) {
      e.printStackTrace();

    }
  }

}
