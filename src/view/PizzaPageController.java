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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.Pizza;
import model.PizzaTopping;
import model.Sides;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.UUID;

public class PizzaPageController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(PizzaPageController.class.getName());

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

    // Method for adding order to cart
    @FXML
    private void handleAddToCartButton(ActionEvent event) {
        /*Set default value of pizza size and crust to empty string
        and generate pizza ID*/
        String pizzaCrust, pizzaSize = pizzaCrust = "", pizzaId = UUID.randomUUID().toString();

        // Create the list of toppings
        List<PizzaTopping> toppings = new ArrayList<>();

        // Set pizza crust based on user's choice
        if (pan.isSelected()) {
            pizzaCrust = "Pan";
        } else if (thin.isSelected()) {
            pizzaCrust = "Thin";
        } else if (regular.isSelected()) {
            pizzaCrust = "Regular";
        }

        // Set pizza size based on user's choice
        if (small.isSelected()) {
            pizzaSize = "Small";
        } else if (medium.isSelected()) {
            pizzaSize = "Medium";
        } else if (large.isSelected()) {
            pizzaSize = "Large";
        } else if (extra_large.isSelected()) {
            pizzaSize = "Extra Large";
        }

        if (pizzaCrust.isEmpty() || pizzaSize.isEmpty()) {

            // Display error message if crust or size i snot selected
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Error!");
            a.setContentText("Please select crust and size before adding order to cart.");
            a.showAndWait();
            return;

        }

        // Calculate pizza price and add pizza based on the chosen size
        switch (pizzaSize) {
            case "Small":
                // Add topping with price of $0.5 to the list of toppings
                addToppings(toppings, pizzaId, 0.50);

                /*Display error message if total size number of toppings
                exceeds 4*/
                if (verifyAmountOfToppings(toppings)) {
                    break;
                }
                // Add pizza to the list of orders
                DatabaseHandler.orderItemList.add(new Pizza(pizzaId, 1, 4.0 + calculateToppingTotalPrice(toppings), pizzaSize, pizzaCrust, toppings));
                displaySuccessMessage();
                break;
            case "Medium":
                // Add topping with price of $0.75 to the list of toppings
                addToppings(toppings, pizzaId, 0.75);

                /*Display error message if total size number of toppings
                exceeds 4*/
                if (verifyAmountOfToppings(toppings)) {
                    break;
                }
                // Add pizza to the list of orders
                DatabaseHandler.orderItemList.add(new Pizza(pizzaId, 1, 6.0 + calculateToppingTotalPrice(toppings), pizzaSize, pizzaCrust, toppings));
                displaySuccessMessage();
                break;
            case "Large":
                // Add topping with price of $1.0 to the list of toppings
                addToppings(toppings, pizzaId, 1.0);

                /*Display error message if total size number of toppings
                exceeds 4*/
                if (verifyAmountOfToppings(toppings)) {
                    break;
                }
                // Add pizza to the list of orders
                DatabaseHandler.orderItemList.add(new Pizza(pizzaId, 1, 8.0 + calculateToppingTotalPrice(toppings), pizzaSize, pizzaCrust, toppings));
                displaySuccessMessage();
                break;
            case "Extra Large":
                // Add topping with price of $1.25 to the list of toppings
                addToppings(toppings, pizzaId, 1.25);

                /*Display error message if total size number of toppings
                exceeds 4*/
                if (verifyAmountOfToppings(toppings)) {
                    break;
                }
                // Add pizza to the list of orders
                DatabaseHandler.orderItemList.add(new Pizza(pizzaId, 1, 10.0 + calculateToppingTotalPrice(toppings), pizzaSize, pizzaCrust, toppings));
                displaySuccessMessage();
                break;
        }
    }

    // Method for calculating the total prices for all toppings
    private double calculateToppingTotalPrice(List<PizzaTopping> toppings) {
        double totalPrice = 0.0;
        for (PizzaTopping topping : toppings
        ) {
            totalPrice += topping.getPrice();
        }
        return totalPrice;
    }

    // Method for adding toppings based on customer's choice
    private void addToppings(List<PizzaTopping> toppings, String pizzaId, double price) {
        if (cheese.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Cheese", price));
        }
        if (pepperoni.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Pepperoni", price));
        }
        if (sausage.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Sausage", price));
        }
        if (ham.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Ham", price));
        }
        if (green_peppers.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Green peppers", price));
        }
        if (onions.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Onions", price));
        }
        if (mushrooms.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Mushrooms", price));
        }
        if (pineapple.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Pineapple", price));
        }
        if (tomatoes.isSelected()) {
            toppings.add(new PizzaTopping(pizzaId, "Tomatoes", price));
        }
    }

    // Method for displaying error message in case total number of toppings exceeds 4
    private boolean verifyAmountOfToppings(List<PizzaTopping> toppings) {
        if (toppings.size() > 4) {

            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Error!");
            a.setContentText("Please select a maximum of 4 toppings.");
            a.showAndWait();
            return true;

        }
        return false;
    }

    private void displaySuccessMessage() {


        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setHeaderText("Success");
        a.setContentText("Order has been added to cart successfully.");
        a.showAndWait();

        clearEntries();
    }

    // Method for resetting all text fields and radio buttons
    private void clearEntries() {
        thin.setSelected(false);
        regular.setSelected(false);
        small.setSelected(false);
        medium.setSelected(false);
        large.setSelected(false);
        extra_large.setSelected(false);
        cheese.setSelected(false);
        onions.setSelected(false);
        pepperoni.setSelected(false);
        sausage.setSelected(false);
        ham.setSelected(false);
        tomatoes.setSelected(false);
        green_peppers.setSelected(false);
        mushrooms.setSelected(false);
        pineapple.setSelected(false);
        pan.setSelected(false);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}