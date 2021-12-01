package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CheckoutPageController {

    @FXML
    private TextField addressTxtField;

    @FXML
    private TextField cardNumTxtField;

    @FXML
    private TextField cityTxtField;

    @FXML
    private TextField expirationTextField;

    @FXML
    private ChoiceBox<String> orderTypeChoiceBox = new ChoiceBox<>();
    ObservableList<String> availableOrderTypeChoices = FXCollections.observableArrayList("Delivery", "Pick-up");
    //orderTypeChoiceBox.setItems(availableOrderTypeChoices);

    @FXML
    private ChoiceBox<String> paymentTypeChoiceBox = new ChoiceBox<>();
    ObservableList<String> availablePaymentTypeChoices = FXCollections.observableArrayList("Cash", "Credit or Debit Card", "Check");
    //paymentTypeChoiceBox.setItems(availablePaymentTypeChoices);

    @FXML
    private TextField securityTxtField;

    @FXML
    private TextField zipTxtField;

    @FXML
    void handleCancelButtonAction(ActionEvent event) {

    }

}
