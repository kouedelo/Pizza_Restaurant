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
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Beverage;
import model.Sides;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class BeverageItemPageController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(BeverageItemPageController.class.getName());

    @FXML
    private RadioButton smallRadioBtn;

    @FXML
    private ToggleGroup size;

    @FXML
    private RadioButton mediumRadioBtn;

    @FXML
    private RadioButton largeRadioBtn;

    @FXML
    private Text nameText;

    @FXML
    private TextField quantityTxtField;

    public void setNameText(String name) {
        this.nameText.setText(name);
    }

    // Method for handling add to cart action
    @FXML
    private void handleAddToCartButton(ActionEvent event) {
        try {
            // Set default quantity to one
            int quantity = 1;
            if (!quantityTxtField.getText().isEmpty()) {
                // Get quantity entered by the customer
                quantity = Integer.parseInt(quantityTxtField.getText());
            }
            if (smallRadioBtn.isSelected()) {
                // Add a side with small size into the list of orders
                DatabaseHandler.orderItemList.add(new Beverage(UUID.randomUUID().toString(), quantity, 1.0, nameText.getText(), "Small"));
            }
            if (mediumRadioBtn.isSelected()) {
                // Add a side with medium size into the list of orders
                DatabaseHandler.orderItemList.add(new Beverage(UUID.randomUUID().toString(), quantity, 1.0, nameText.getText(), "Medium"));
            }
            if (largeRadioBtn.isSelected()) {
                // Add a side with large size into the list of orders
                DatabaseHandler.orderItemList.add(new Beverage(UUID.randomUUID().toString(), quantity, 1.0, nameText.getText(), "Large"));
            }

            if (!smallRadioBtn.isSelected() && !mediumRadioBtn.isSelected() && !largeRadioBtn.isSelected()) {

                // Display an error message if no size is selected
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setHeaderText("Error!");
                a.setContentText("Please select a size before adding order to cart.");
                a.showAndWait();
                return;
            }

            // Display success message if order is added to cart successfully
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Success");
            a.setContentText("Order has been added to cart successfully.");
            a.showAndWait();

            // Clear all text fields and reset radio buttons
            clearEntries();

        } catch (Exception ex) {

        }
    }

    // handle the cancel action
    @FXML
    private void handleCancelButton(ActionEvent event) {
        ((Stage) largeRadioBtn.getScene().getWindow()).close();
    }

    // Method for resetting all text fields and radio buttons
    private void clearEntries() {
        smallRadioBtn.setSelected(false);
        mediumRadioBtn.setSelected(false);
        largeRadioBtn.setSelected(false);
        quantityTxtField.clear();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}