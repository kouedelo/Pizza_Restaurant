package view;

import dao.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Customer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    /*Define a static logger variable so that it references
        the Logger instance named "DatabaseHandler".*/
    private final static Logger LOGGER = LogManager.getLogger(LoginController.class.getName());

    @FXML
    private TextField phoneNumberTxtField;

    @FXML
    private PasswordField passwordTxtField;

    @FXML
    private Text errorText;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Get all customers from the database
        dao.DatabaseHandler.getInstance().getPreferences();
    }

    // Method for handling logging action
    @FXML
    private void handleLoginButtonAction(ActionEvent event) {
        String phoneNumber = phoneNumberTxtField.getText();
        String password = passwordTxtField.getText();
        Customer currentCustomer;

        currentCustomer = DatabaseHandler.getInstance().returnUser(phoneNumber, password);
        if (currentCustomer != null) {
            closeStage();
            loadOrderPage(currentCustomer);
            LOGGER.log(Level.INFO, "User successfully logged in {}", phoneNumber);
        } else {
            errorText.setText("Incorrect Phone number or password");
        }

    }

    // Method for handling cancelling action
    @FXML
    private void handleCancelButtonAction(ActionEvent event) {
        // Redirect customer to homepage
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

    private void closeStage() {
        ((Stage) phoneNumberTxtField.getScene().getWindow()).close();
    }

    // Method for loading the homepage
    void loadOrderPage(Customer currentCustomer) {
        try {
            System.out.println("Current Staff Phone number: " + currentCustomer.getPhoneNumber() + "\n");
            System.out.println("Current Staff Password: " + currentCustomer.getPassword() + "\n");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/orderPage.fxml"));
            Parent parent = loader.load();
            orderPageController controller = loader.getController();
            controller.currentCustomer = currentCustomer;
            controller.setNameLabel("Welcome " + currentCustomer.getFirstName());
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }
}
