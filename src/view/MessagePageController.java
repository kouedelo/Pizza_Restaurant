package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class MessagePageController {
    @FXML
    private Label message;

    public void setMessage(String message) {
        this.message.setText(message);
    }

    @FXML
    private void handleOkButton(ActionEvent event) {
        ((Stage) message.getScene().getWindow()).close();
    }
}
