package view;

import dao.DatabaseHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Beverage;
import model.Sides;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class BeverageItemPageController implements Initializable {

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

    @FXML
    private void handleAddToCartButton(ActionEvent event) {
        try {
            int quantity = 1;
            if (!quantityTxtField.getText().isEmpty()) {
                quantity = Integer.parseInt(quantityTxtField.getText());
            }
            if (smallRadioBtn.isSelected()) {
                DatabaseHandler.orderItemList.add(new Beverage(UUID.randomUUID().toString(), quantity, 1.0, nameText.getText(), "Small"));
            }
            if (mediumRadioBtn.isSelected()) {
                DatabaseHandler.orderItemList.add(new Beverage(UUID.randomUUID().toString(), quantity, 1.0, nameText.getText(), "Medium"));
            }
            if (largeRadioBtn.isSelected()) {
                DatabaseHandler.orderItemList.add(new Beverage(UUID.randomUUID().toString(), quantity, 1.0, nameText.getText(), "Large"));
            }

            ((Stage) largeRadioBtn.getScene().getWindow()).close();
        } catch (Exception ex) {

        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
