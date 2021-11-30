package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
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
    private AnchorPane mainPane;

    @FXML
    private void handlePizzaButton(ActionEvent event) {
        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/pizzaPage.fxml"));
            loader.load();
            PizzaPageController controller = loader.getController();
            mainPane.getChildren().clear();
            mainPane.getChildren().add(controller.getPizzaPane());
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @FXML
    private void handleBeverageButton(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/beveragePage.fxml"));
            loader.load();
            BeveragePageController controller = loader.getController();
            mainPane.getChildren().clear();
            mainPane.getChildren().add(controller.getBeveragePane());
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @FXML
    private void handleSidesButton(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/sidePage.fxml"));
            loader.load();
            sidePageController controller = loader.getController();
            mainPane.getChildren().clear();
            mainPane.getChildren().add(controller.getSidesPane());
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @FXML
    private void handleCartButton(ActionEvent event) {

        try {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/cartPage.fxml"));
            loader.load();
            CartPageController controller = loader.getController();
            mainPane.getChildren().clear();
            mainPane.getChildren().add(controller.getCartPane());
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }


    @FXML
    private void handleLogOutButton(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/homePage.fxml"));
            Parent parent = loader.load();
            HomePageController controller = loader.getController();
            controller.currentCustomer = currentCustomer;
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            ((Stage) mainPane.getScene().getWindow()).close();
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @FXML
    private void handleSettingsButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
