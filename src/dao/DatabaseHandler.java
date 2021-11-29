package dao;

// Import log4j classes for logging purposes.

import model.*;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHandler {

    /*Define a static logger variable so that it references
    the Logger instance named "DatabaseHandler".*/
    private final static Logger LOGGER = LogManager.getLogger(DatabaseHandler.class.getName());

    // Instance variable for using database operations
    private static DatabaseHandler handler = null;

    // Mysql Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pizza_restaurant?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false";
    private static final String username = "";
    private static final String password = "";
    private static Connection conn = null;
    private static Statement stmt = null;

    // List of all customers
    public static List<Customer> customerList = new ArrayList<>();

    // List of ordered items
    public static List<OrderItem> orderItemList = new ArrayList<>();

    // No-arg constructor
    private DatabaseHandler() {
    }

    /* Initializer block for
    automatically connecting to the database*/
    static {
        createConnection();
        //populateOrders();
        //inflateDB();
    }

    // Method for connecting to the database
    private static void createConnection() {
        // Register mysql driver
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found !!");
            return;
        }

        System.out.println("MySQL JDBC Driver Registered!");

        conn = null;
        stmt = null;

        // Connect to database using username and password
        try {
            conn = DriverManager.getConnection(DB_URL, username, password);
            stmt = conn.createStatement();
        } catch (SQLException e) {
            System.out.println("Connection Failed! Check output console");

            return;
        }
        System.out.println("Connection to database established!");
    }

    public static void main(String[] args) /*throws Exception*/ {
        DatabaseHandler.getInstance();
    }

    // Method for returning an instance of the DatabaseHandler class
    public static DatabaseHandler getInstance() {
        if (handler == null) {
            handler = new DatabaseHandler();
        }
        return handler;
    }

    // Method for returning the current connection
    public Connection getConnection() {
        return conn;
    }

    // Method for getting all customers from the database
    public void getPreferences() {

        customerList.clear();
        String qu = "SELECT * FROM customer";
        ResultSet rs = execQuery(qu);
        try {
            while (rs.next()) {
                String phoneNumber = rs.getString("phone_number");
                String password = rs.getString("password");
                String email = rs.getString("email");
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String city = rs.getString("city");
                String state = rs.getString("state");
                String zipCode = rs.getString("zip_code");
                customerList.add(new Customer(phoneNumber, password, email, firstName, lastName, city, state, zipCode));

            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DatabaseHandler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Method for executing queries
    public ResultSet execQuery(String query) {
        ResultSet result;
        try {
            //conn = DriverManager.getConnection(DB_URL, username, password);
            stmt = conn.createStatement();
            result = stmt.executeQuery(query);
        } catch (SQLException ex) {
            System.out.println("Exception at execQuery:dataHandler" + ex.getLocalizedMessage());
            return null;
        } finally {
        }
        return result;
    }

    // Method for getting the current user after logging in
    public Customer returnUser(String phoneNumber, String password) {
        Customer currentUser = null;
        for (Customer customer : customerList) {
            if (phoneNumber.equals(customer.getPhoneNumber()) && password.equals(customer.getPassword())) {
                currentUser = customer;
            }
        }
        return currentUser;
    }

    // Method for updating customer data
    public boolean updateCustomer(Customer customer) {
        try {

            String update = "UPDATE customer SET phone_number=?, password=?, email=?,first_name=?,last_name=?,city=?,state=?,zip_code=? WHERE phone_number=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(update);
            stmt.setString(1, customer.getPhoneNumber());
            stmt.setString(2, customer.getPassword());
            stmt.setString(3, customer.getEmail());
            stmt.setString(4, customer.getFirstName());
            stmt.setString(5, customer.getLastName());
            stmt.setString(6, customer.getCity());
            stmt.setString(7, customer.getState());
            stmt.setString(8, customer.getZipCode());
            stmt.setString(9, customer.getPhoneNumber());
            stmt.setString(10, customer.getPassword());
            int res = stmt.executeUpdate();
            return (res > 0);
        } catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }

    // Method for deleting a customer
    public boolean deleteCustomer(Customer customer) {
        try {
            String deleteStatement = "DELETE FROM customer WHERE phone_number=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(deleteStatement);
            stmt.setString(1, customer.getPhoneNumber());
            stmt.setString(2, customer.getPassword());
            int res = stmt.executeUpdate();
            if (res == 1) {
                return true;
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }

    private static void populateOrders(){
        Pizza pizza1 = new Pizza("2244", 2,  18.7,  "medium",  "handmade");
        pizza1.getToppings().add(new PizzaTopping("2244",  "tomatoes",  2.99));
        pizza1.getToppings().add(new PizzaTopping("2244",  "cheese",  2.99));

        orderItemList.add(pizza1);
        orderItemList.add(new Beverage( "667",  9,  3.9,  "coca cola"));
        orderItemList.add(new Sides( "667",  9,  3.9,  "bread"));
    }
}
