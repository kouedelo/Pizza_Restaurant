package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PizzaPageController implements Initializable {
    @FXML
    private AnchorPane pizzaPane;

    @FXML
    private RadioButton thin;

    @FXML
    private ToggleGroup crust;

    @FXML
    private RadioButton regular;

    @FXML
    private RadioButton small;

    @FXML
    private ToggleGroup size;

    @FXML
    private RadioButton medium;

    @FXML
    private RadioButton large;

    @FXML
    private RadioButton extra_large;

    @FXML
    private RadioButton cheese;

    @FXML
    private RadioButton onions;

    @FXML
    private RadioButton pepperoni;

    @FXML
    private RadioButton sausage;

    @FXML
    private RadioButton ham;

    @FXML
    private RadioButton green_peppers;

    @FXML
    private RadioButton mushrooms;

    @FXML
    private RadioButton pineapple;

    @FXML
    private RadioButton tomatoes;

    @FXML
    private RadioButton pan;

    public AnchorPane getPizzaPane() {
        return pizzaPane;
    }

    @FXML
    private void handleAddToCartButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}