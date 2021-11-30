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

    @FXML
    private void handleCancelButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homePage.fxml"));
            Parent parent = loader.load();
            HomePageController controller = loader.getController();
            //controller.currentCustomer = currentCustomer;
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

    @FXML
    private void handleCreateAccountButton(ActionEvent event) {
        String firstName = firstNamextField.getText();
        String city = cityTxtField.getText();
        String password = passwordTxtField.getText();
        String phoneNumber = phoneNumberTxtField.getText();
        String email = emailTxtField.getText();
        String lastName = lastNameTxtField.getText();
        String confirmPassword = confirmPasswordTxtField.getText();
        String zipCode = zipCodeTxtField.getText();
        String state = stateTxtField.getText();

        if (firstName.isEmpty() || city.isEmpty() || password.isEmpty() || phoneNumber.isEmpty() || email.isEmpty() || lastName.isEmpty()
                || confirmPassword.isEmpty() || zipCode.isEmpty()
                || state.isEmpty()) {

           /* try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/messagePage.fxml"));
                Parent parent = loader.load();
                MessagePageController controller = loader.getController();
                controller.setMessage("Please fill all fields.");
                Stage stage = new Stage(StageStyle.DECORATED);
                stage.setTitle("Error!");
                stage.setScene(new Scene(parent));
                stage.show();
                //LibraryAssistantUtil.setStageIcon(stage);
            } catch (IOException ex) {
                LOGGER.log(Level.ERROR, "{}", ex);
            }*/

            this.errorText.setText("Please fill all fields.");
            return;
        }

        if (DataHelper.isPhoneNumberExists(phoneNumber)) {
            this.errorText.setText("Phone number already exits.");
            return;
        }

        if (!password.equals(confirmPassword)) {
            this.errorText.setText("Passwords doesn't match.");
            return;
        }

        Customer newCustomer = new Customer(phoneNumber, password, email, firstName, lastName, city, state, zipCode);
        boolean result = DataHelper.insertNewCustomer(newCustomer);
        if (result) {
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
            this.errorText.setText("An error occurred while creating account.");
        }
    }
}
