package view;

import dao.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import model.OrderItem;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class CartPageController implements Initializable {

    private final static Logger LOGGER = LogManager.getLogger(CartPageController.class.getName());

    @FXML
    private TableView<OrderItem> orderTable;

    @FXML
    private TableColumn<OrderItem, String> pizzaSizeColumn;

    @FXML
    private TableColumn<OrderItem, String> pizzaCrustColumn;

    @FXML
    private TableColumn<OrderItem, String> pizzaToppingsColumn;

    @FXML
    private TableColumn<OrderItem, String> nameColumn;

    @FXML
    private TableColumn<OrderItem, Integer> quantityColumn;

    @FXML
    private TableColumn<OrderItem, Double> prizeColumn;

    @FXML
    private Text priceText;

    @FXML
    private AnchorPane cartPane;

    public AnchorPane getCartPane() {
        return cartPane;
    }

    @FXML
    private void handleRemoveFromCartButton(ActionEvent event) {
        OrderItem selectedForDeletion = orderTable.getSelectionModel().getSelectedItem();
        if (selectedForDeletion == null) {


            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setHeaderText("Error!");
            a.setContentText("Please select an item first.");
            a.showAndWait();

            return;
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting item");
        alert.setContentText("Are you sure want to delete the item " + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        if (answer.get() == ButtonType.OK) {
            DatabaseHandler.orderItemList.remove(selectedForDeletion);
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            if (!DatabaseHandler.orderItemList.contains(selectedForDeletion)) {
                a.setHeaderText("Delete Successfull");
                a.setContentText("The item has been successfully deleted");
                a.showAndWait();
                orderTable.getItems().clear();
                orderTable.setItems(FXCollections.observableArrayList(DatabaseHandler.orderItemList));
                orderTable.refresh();
                priceText.setText("$ " + calculateSubtotal());
            } else {
                a.setHeaderText("Delete Unsuccessful");
                a.setContentText("The item could not be deleted");
                a.showAndWait();
            }
        }
    }

    @FXML
    private void handleClearCartButton(ActionEvent event) {
        DatabaseHandler.orderItemList.clear();
        orderTable.setItems(FXCollections.observableArrayList(DatabaseHandler.orderItemList));
        orderTable.refresh();
        priceText.setText("$ " + calculateSubtotal());
    }

    @FXML
    private void handleCheckoutButton(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initCol();
        orderTable.setItems(FXCollections.observableArrayList(DatabaseHandler.orderItemList));
        priceText.setText("$ " + calculateSubtotal());
    }

    private void initCol() {
        pizzaSizeColumn.setCellValueFactory(new PropertyValueFactory<>("size"));
        pizzaCrustColumn.setCellValueFactory(new PropertyValueFactory<>("crust"));
        pizzaToppingsColumn.setCellValueFactory(new PropertyValueFactory<>("toppingsNames"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        prizeColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
    }

    private String calculateSubtotal() {
        double totalPrice = 0.0;
        if (DatabaseHandler.orderItemList.size() > 0) {
            for (OrderItem order : DatabaseHandler.orderItemList
            ) {
                totalPrice += order.getPrice();
            }
        }

        return "" + (float) totalPrice;
    }
}
