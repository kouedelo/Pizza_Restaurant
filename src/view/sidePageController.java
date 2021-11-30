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

    @FXML
    private void handleAddToCartButton(ActionEvent event) {

        try {
            if (breadStickRadioBtn.isSelected()) {
                if (breadStickTxtField.getText().isEmpty()) {
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), 1, breadSticksPrice, breadSticksName));
                } else {
                    int quantity = Integer.parseInt(breadStickTxtField.getText());
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), quantity, breadSticksPrice, breadSticksName));
                }
            }

            if (breadStickBitesRadioBtn.isSelected()) {
                if (breadStickBitesTxtField.getText().isEmpty()) {
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), 1, breadSticksBitesPrice, breadSticksBitesName));

                } else {
                    int quantity = Integer.parseInt(breadStickBitesTxtField.getText());
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), quantity, breadSticksBitesPrice, breadSticksBitesName));
                }
            }

            if (chocolateCookieRadioBtn.isSelected()) {
                if (chocolateCookieTxtField.getText().isEmpty()) {
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), 1, chocolateCookiePrice, chocolateCookieName));
                } else {
                    int quantity = Integer.parseInt(chocolateCookieTxtField.getText());
                    DatabaseHandler.orderItemList.add(new Sides(UUID.randomUUID().toString(), quantity, chocolateCookiePrice, chocolateCookieName));
                }
            } else if (!breadStickRadioBtn.isSelected() && !breadStickBitesRadioBtn.isSelected() && !chocolateCookieRadioBtn.isSelected()) {

                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Error!");
                a.setContentText("Please select a side before adding order to cart.");
                a.showAndWait();
                return;
            }

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Success!");
            a.setContentText("Order has been added to cart successfully..");
            a.showAndWait();

            clearEntries();
        } catch (Exception ex) {

        }
    }

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
