package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Customer;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import sample.Main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class orderPageController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(orderPageController.class.getName());

    // Variable for storing current user
    public static Customer currentCustomer;

    @FXML
    private Pane MainPane;

    @FXML
    private void handlePizzaButton(ActionEvent event) {
        /*try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/orderPage.fxml"));
            Parent parent = loader.load();
            orderPageController controller = loader.getController();
            controller.currentCustomer = currentCustomer;
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            ((Stage) login.getScene().getWindow()).close();
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }*/
    }

    @FXML
    private void handleBeverageButton(ActionEvent event) {

    }

    @FXML
    private void handleSidesButton(ActionEvent event) {

    }

    @FXML
    private void handleCartButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
