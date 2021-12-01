package view;

import dao.DataHelper;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Customer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;


public class CreateAccountController {
    /*Define a static logger variable so that it references
        the Logger instance named "CreateAccountController".*/
    private final static Logger LOGGER = LogManager.getLogger(CreateAccountController.class.getName());

    @FXML
    private TextField firstNamextField;

    @FXML
    private TextField cityTxtField;

    @FXML
    private TextField passwordTxtField;

    @FXML
    private Label errorText;

    @FXML
    private TextField phoneNumberTxtField;

    @FXML
    private TextField emailTxtField;

    @FXML
    private TextField lastNameTxtField;

    @FXML
    private Button create_account;

    @FXML
    private TextField confirmPasswordTxtField;

    @FXML
    private TextField zipCodeTxtField;

    @FXML
    private TextField stateTxtField;

    @FXML
    private Button create_account1;

    public void setErrorText(String errorText) {
        this.errorText.setText(errorText);
    }

    // Method for handling cancelling action
    @FXML
    private void handleCancelButton(ActionEvent event) {
        // Redirect user to homepage
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homePage.fxml"));
            Parent parent = loader.load();
            HomePageController controller = loader.getController();
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            ((Stage) phoneNumberTxtField.getScene().getWindow()).close();
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    // Handle create account button
    @FXML
    private void handleCreateAccountButton(ActionEvent event) {

        // Get all entries from form
        String firstName = firstNamextField.getText();
        String city = cityTxtField.getText();
        String password = passwordTxtField.getText();
        String phoneNumber = phoneNumberTxtField.getText();
        String email = emailTxtField.getText();
        String lastName = lastNameTxtField.getText();
        String confirmPassword = confirmPasswordTxtField.getText();
        String zipCode = zipCodeTxtField.getText();
        String state = stateTxtField.getText();

        // Display error message if not all fields are filled
        if (firstName.isEmpty() || city.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || lastName.isEmpty()
                || confirmPassword.isEmpty() || zipCode.isEmpty()
                || state.isEmpty()) {



            this.errorText.setText("Please fill all fields.");
            return;
        }


        // Verify whether phone number entered is already found in the database
        if (DataHelper.isPhoneNumberExists(phoneNumber)) {
            this.errorText.setText("Phone number already exits.");
            return;
        }

        // Display error message if entered passwords don't match
        if (!password.equals(confirmPassword)) {
            this.errorText.setText("Passwords doesn't match.");
            return;
        }

        Customer newCustomer = new Customer(phoneNumber, password, email, firstName, lastName, city, state, zipCode);

        // Insert new customer into database
        boolean result = DataHelper.insertNewCustomer(newCustomer);
        if (result) {
            // Redirect to the order page if account is created successfully
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/orderPage.fxml"));
                Parent parent = loader.load();
                orderPageController controller = loader.getController();
                controller.currentCustomer = newCustomer;
                controller.setNameLabel("Welcome " + newCustomer.getFirstName());
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("Pizza App");
                stage.setScene(new Scene(parent));
                ((Stage) phoneNumberTxtField.getScene().getWindow()).close();
                stage.show();
                //LibraryAssistantUtil.setStageIcon(stage);
            } catch (IOException ex) {
                LOGGER.log(Level.ERROR, "{}", ex);
            }
        } else {
            // Display error if account could not be created
            this.errorText.setText("An error occurred while creating account.");
        }
    }
}
