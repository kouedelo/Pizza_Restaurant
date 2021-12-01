package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BeveragePageController implements Initializable {
    /*Define a static logger variable so that it references
        the Logger instance named "BeveragePageController".*/
    private final static Logger LOGGER = LogManager.getLogger(BeveragePageController.class.getName());

    @FXML
    private AnchorPane beveragePane;

    public AnchorPane getBeveragePane() {
        return beveragePane;
    }

    // Method for handling the order pepsi action
    @FXML
    private void handlePepsiButton(ActionEvent event) {
        // Redirect to the pepsi order page
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/beverageItemPage.fxml"));
            Parent parent = loader.load();
            BeverageItemPageController controller = loader.getController();
            controller.setNameText("Pepsi");
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    // Method for handling the order diet pepsi action
    @FXML
    private void handleDietPepsiButton(ActionEvent event) {
        // Redirect to the diet pepsi order page
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/beverageItemPage.fxml"));
            Parent parent = loader.load();
            BeverageItemPageController controller = loader.getController();
            controller.setNameText("Diet Pepsi");
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    // Method for handling the order orange action
    @FXML
    private void handleOrangeButton(ActionEvent event) {
        // Redirect to the orange order page
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/beverageItemPage.fxml"));
            Parent parent = loader.load();
            BeverageItemPageController controller = loader.getController();
            controller.setNameText("Orange");
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    // Method for handling the order diet orange action
    @FXML
    private void handleDietOrangeButton(ActionEvent event) {
        // Redirect to the diet orange order page
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/beverageItemPage.fxml"));
            Parent parent = loader.load();
            BeverageItemPageController controller = loader.getController();
            controller.setNameText("Diet Orange");
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    // Method for handling the order lemonade action
    @FXML
    private void handleLemonadeButton(ActionEvent event) {

        // Redirect to the lemonade order page
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/beverageItemPage.fxml"));
            Parent parent = loader.load();
            BeverageItemPageController controller = loader.getController();
            controller.setNameText("Lemonade");
            Stage stage = new Stage(StageStyle.DECORATED);
            stage.setTitle("Pizza App");
            stage.setScene(new Scene(parent));
            stage.show();
            //LibraryAssistantUtil.setStageIcon(stage);
        } catch (IOException ex) {
            LOGGER.log(Level.ERROR, "{}", ex);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
