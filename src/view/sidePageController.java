package view;

import dao.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Sides;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class sidePageController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(sidePageController.class.getName());

    @FXML
    private AnchorPane SidesPane;

    @FXML
    private RadioButton breadStickRadioBtn;

    @FXML
    private RadioButton breadStickBitesRadioBtn;

    @FXML
    private RadioButton chocolateCookieRadioBtn;

    @FXML
    private TextField breadStickTxtField;

    @FXML
    private TextField breadStickBitesTxtField;

    @FXML
    private TextField chocolateCookieTxtField;

    private String breadSticksName = "Bread sticks";

    private String breadSticksBitesName = "Bread stick bites";

    private String chocolateCookieName = "Big chocolate chip cookie";

    private double breadSticksPrice = 4.0;

    private double breadSticksBitesPrice = 2.0;

    private double chocolateCookiePrice = 4.0;

    public AnchorPane getSidesPane() {
        return SidesPane;
    }

    // Method for adding order to cart
    @FXML
    private void handleAddToCartButton(ActionEvent event) {

        try {
            // verify if bread stick option is chosen
            if (breadStickRadioBtn.isSelected()) {
                if (breadStickTxtField.getText().isEmpty()) {
                    // If quantity is not entered, add a side with one as default quantity
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), 1, breadSticksPrice, breadSticksName));
                } else {
                    int quantity = Integer.parseInt(breadStickTxtField.getText());
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), quantity, breadSticksPrice, breadSticksName));
                }
            }

            // verify if bread stick bites option is chosen
            if (breadStickBitesRadioBtn.isSelected()) {
                if (breadStickBitesTxtField.getText().isEmpty()) {
                    // If quantity is not entered, add a side with one as default quantity
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), 1, breadSticksBitesPrice, breadSticksBitesName));

                } else {
                    int quantity = Integer.parseInt(breadStickBitesTxtField.getText());
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), quantity, breadSticksBitesPrice, breadSticksBitesName));
                }
            }

            // verify if chocolate cookie option is chosen
            if (chocolateCookieRadioBtn.isSelected()) {
                if (chocolateCookieTxtField.getText().isEmpty()) {
                    // If quantity is not entered, add a side with one as default quantity
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), 1, chocolateCookiePrice, chocolateCookieName));
                } else {
                    int quantity = Integer.parseInt(chocolateCookieTxtField.getText());
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), quantity, chocolateCookiePrice, chocolateCookieName));
                }
            } else if (!breadStickRadioBtn.isSelected() && !breadStickBitesRadioBtn.isSelected() && !chocolateCookieRadioBtn.isSelected()) {

                // Display error message if no side is chosen
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Error!");
                a.setContentText("Please select a side before adding order to cart.");
                a.showAndWait();
                return;
            }

            // Display success message when order is added to cart successfully
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Success!");
            a.setContentText("Order has been added to cart successfully..");
            a.showAndWait();

            // Clear all text fields and reset radio buttons
            clearEntries();
        } catch (Exception ex) {

        }
    }

    // Method for resetting all text fields and radio buttons
    private void clearEntries() {
        breadStickRadioBtn.setSelected(false);
        breadStickBitesRadioBtn.setSelected(false);
        chocolateCookieRadioBtn.setSelected(false);
        breadStickTxtField.clear();
        breadStickBitesTxtField.clear();
        chocolateCookieTxtField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
