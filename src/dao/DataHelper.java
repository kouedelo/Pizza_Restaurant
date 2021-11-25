package dao;

import model.Customer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataHelper {

    /*Define a static logger variable so that it references
    the Logger instance named "DatabaseHandler".*/
    private final static Logger LOGGER = LogManager.getLogger(DatabaseHandler.class.getName());

    // Method to insert new customer into the database
    public static boolean insertNewCustomer(Customer customer) {
        try {
            PreparedStatement statement = DatabaseHandler.getInstance().getConnection().prepareStatement(
                    "INSERT INTO customer(phone_number, password, email, first_name, last_name, city, state, zip_code) VALUES(?,?,?,?,?,?,?,?)");
            statement.setString(1, customer.getPhoneNumber());
            statement.setString(2, customer.getPassword());
            statement.setString(4, customer.getEmail());
            statement.setString(3, customer.getFirstName());
            statement.setString(5, customer.getLastName());
            statement.setString(6, customer.getCity());
            statement.setString(7, customer.getState());
            statement.setString(8, customer.getZipCode());
            return statement.executeUpdate() > 0;
        } catch (SQLException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
        return false;
    }
}
