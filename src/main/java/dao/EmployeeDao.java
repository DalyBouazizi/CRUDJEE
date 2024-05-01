package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import model.Employee;

public class EmployeeDao {
	

    public int registerEmployee(Employee employee) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO person" +
            "  (first_name, last_name, username, password, address, contact,role) VALUES " +
            " ( ?, ?, ?, ?,?,?,?);";

        int result = 0;

        Class.forName("com.mysql.cj.jdbc.Driver");


        try (
        		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?serverTimezone=Europe/Paris", "root", "");


        	
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            // preparedStatement.setInt(1, 1);
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUserName());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());
            preparedStatement.setString(7, employee.getRole());

            System.out.println(preparedStatement);
            
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();
          

        } catch (SQLException e) {
            // process sql exception
            printSQLException(e);
        }
        return result;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    // Method to retrieve all clients from the database
    public  List<Employee> getAllClients() throws ClassNotFoundException {
        List<Employee> clients = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");


        try (
        		
        		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?serverTimezone=Europe/Paris", "root", "");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM person")) {

            while (rs.next()) {
                // Retrieve data from the result set
                int id = rs.getInt("id");
                String firstname = rs.getString("first_name");
                String lastname = rs.getString("last_name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String address = rs.getString("address");
                String contact = rs.getString("contact");
                String role = rs.getString("role");
                

                // Create a new Client object and add it to the list
               
                Employee employee = new Employee();
                
                employee.setFirstName(firstname);
                employee.setLastName(lastname);
                employee.setUserName(username);
                employee.setPassword(password);
                employee.setContact(contact);
                employee.setAddress(address);
                employee.setRole(role);
                
                clients.add(employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any SQL exceptions here
        }

        return clients;
    }
    
    
    
    //--------------------------------------
    
    
    public void deleteClient(int numero) throws ClassNotFoundException, SQLException {
        // SQL query to delete a client by ID
        String DELETE_CLIENT_SQL = "DELETE FROM person WHERE contact = ?";
        
        // Load the database driver
        Class.forName("com.mysql.cj.jdbc.Driver");

       
        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?serverTimezone=Europe/Paris", "root", "");
             // Create a prepared statement with the SQL query
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLIENT_SQL)) {
            
            // Set the client ID parameter in the prepared statement
            preparedStatement.setInt(1, numero);
            
            // Execute the update query to delete the client
            
           
            int rowsAffected = preparedStatement.executeUpdate();
            
            // Check if the deletion was successful
            if (rowsAffected > 0) {
                System.out.println("Client with contact " + numero + " deleted successfully.");
            } else {
                System.out.println("No client found with contact " + numero + ".");
            }
        }
    }
    
    //--------------------------------------------------------
    public boolean editEmployee(Employee employee) throws SQLException, ClassNotFoundException {
        String UPDATE_EMPLOYEE_SQL = "UPDATE person SET first_name = ?, last_name = ?, username = ?, password = ?, address = ?, contact = ?, role = ? WHERE contact = ?";
        boolean success = false; 
        // Load the database driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish a connection to the database
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?serverTimezone=Europe/Paris", "root", "");
             // Create a prepared statement with the SQL query
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_EMPLOYEE_SQL)) {

            // Set the parameters for the prepared statement
            preparedStatement.setString(1, employee.getFirstName());
            preparedStatement.setString(2, employee.getLastName());
            preparedStatement.setString(3, employee.getUserName());
            preparedStatement.setString(4, employee.getPassword());
            preparedStatement.setString(5, employee.getAddress());
            preparedStatement.setString(6, employee.getContact());
            preparedStatement.setString(7, employee.getRole());
            preparedStatement.setString(8, employee.getContact()); // Use contact as the WHERE clause condition

            // Execute the update query to edit the employee's information
            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                success = true; // Update successful
            }
            return success; // Return whether the update operation was successful
        }
            
        }
    

    
    
    
    //---------------------------------
    public String[] checkLogin(String username, String password) throws ClassNotFoundException, SQLException {
    	String[] userDetails = new String[8];
        // Load the database driver
    	 
    	
        Class.forName("com.mysql.cj.jdbc.Driver");
       
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projet?serverTimezone=Europe/Paris", "root", "")) {
        	  String sql = "SELECT * FROM person WHERE username = '" + username + "' AND password = '" + password + "'";
            try (Statement statement = conn.createStatement();) {
                
                System.out.println("\n\nSQL Query: " + sql+"\n");
                try (ResultSet rs = statement.executeQuery(sql)) {
                	
                	/////////////////
                	
                	while (rs.next()) {
                        int id = rs.getInt("id");
                        String firstName = rs.getString("first_name");
                        String lastName = rs.getString("last_name");
                        String username1 = rs.getString("username");
                        String password1 = rs.getString("password");
                        String address = rs.getString("address");
                        String contact = rs.getString("contact");
                        String role = rs.getString("role");
                        
                        userDetails[0] = rs.getString("id");
                        userDetails[1] = rs.getString("first_name");
                        userDetails[2] = rs.getString("last_name");
                        userDetails[3] = rs.getString("username");
                        userDetails[4] = rs.getString("password");
                        userDetails[5] = rs.getString("address");
                        userDetails[6] = rs.getString("contact");
                        userDetails[7] = rs.getString("role");
                   
                    }
     
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("\nError executing query: \n" + e.getMessage());
        }
         return userDetails;}
    }
    
    
    
    
    
    
    
    
    

    private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}