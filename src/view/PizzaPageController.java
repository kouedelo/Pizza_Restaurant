package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class PizzaPageController implements Initializable {
    @FXML
    private AnchorPane pizzaPane;

    public AnchorPane getPizzaPane() {
        return pizzaPane;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
