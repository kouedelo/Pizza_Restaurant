package dao;

// Import log4j classes for logging purposes.

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {

    /*Define a static logger variable so that it references
    the Logger instance named "DatabaseHandler".*/
    private final static Logger LOGGER = LogManager.getLogger(DatabaseHandler.class.getName());

    // Instance variable for using database operations
    private static DatabaseHandler handler = null;

    // Mysql Database URL
    private static final String DB_URL = "jdbc:mysql://localhost:3306/pizza_restaurant?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC&useSSL=false";
    private static Connection conn = null;
    private static Statement stmt = null;

    // No-arg constructor
    private DatabaseHandler() {
    }

    /* Initializer block for
    automatically connecting to the database*/
    static {
        createConnection();
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
            conn = DriverManager.getConnection(DB_URL, "root", "sep@2398");
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
}
