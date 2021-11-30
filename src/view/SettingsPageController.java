package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingsPageController {

    @FXML
    private TextField addressTxtField;

    @FXML
    private TextField cityTxtField;

    @FXML
    private TextField firstNameTxtField;

    @FXML
    private TextField lastNameTxtField;

    @FXML
    // could potentially be changed to a textfield if we can't get this working, but I thought it'd be nicer to use a combobox if possible
    private ComboBox<String> stateComboBox;

    @FXML
    public void initialize() {
        stateComboBox.getItems().removeAll(stateComboBox.getItems());
        stateComboBox.getItems().addAll(
                "Alabama", "Alaska", "Arizona", "Arkansas", "California",
                "Colorado", "Connecticut", "Delaware", "Florida", "Georgia",
                "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa",
                "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland",
                "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri",
                "Montana", "Nebraska", "Nevada", "New Hampshire", "New Jersey",
                "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio",
                "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina",
                "South Dakota", "Tennessee", "Texas", "Utah", "Vermont",
                "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming");
        stateComboBox.getSelectionModel().select("");
    }

    @FXML
        private TextField zipTxtField;

    @FXML
        void handleCancelButtonAction (ActionEvent event){


    }
}