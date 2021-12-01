package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Customer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomePageController implements Initializable {
    /*Define a static logger variable so that it references
        the Logger instance named "HomePageController".*/
    private final static Logger LOGGER = LogManager.getLogger(HomePageController.class.getName());

    @FXML
    private Button create_pizza;

    @FXML
    private Button login;

    // Variable for storing current user
    public static Customer currentCustomer = null;

    // Method for displaying login page
    @FXML
    private void handleLoginButton(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

        Scene scene = new Scene(root);

        Stage primaryStage = new Stage(StageStyle.DECORATED);
        primaryStage.setScene(scene);
        ((Stage) login.getScene().getWindow()).close();
        primaryStage.show();
    }

    // Method for displaying create account page
    @FXML
    private void handleCreateAccountButton(ActionEvent event) {

        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/createAccountPage.fxml"));
            Parent parent = loader.load();
            CreateAccountController controller = loader.getController();
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            ((Stage) login.getScene().getWindow()).close();
            stage.show();
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
