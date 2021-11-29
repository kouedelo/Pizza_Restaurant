package view;

import dao.DatabaseHandler;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.OrderItem;

import java.net.URL;
import java.util.ResourceBundle;

public class CartPageController implements Initializable {
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
    private void handleEditButton(ActionEvent event) {

    }

    @FXML
    private void handleRemoveButton(ActionEvent event) {

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
        for (OrderItem order : DatabaseHandler.orderItemList
        ) {
            totalPrice += order.getPrice();
        }
        return "" + (float) totalPrice;
    }
}
