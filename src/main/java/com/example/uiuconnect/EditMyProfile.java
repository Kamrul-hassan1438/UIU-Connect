package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditMyProfile {

    @FXML
    private Button backButton;

    @FXML
    private TextField bloodGroupPicker;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TextField editbatchPicker;

    @FXML
    private PasswordField editcpassword;

    @FXML
    private TextField editdepartmentPicker;

    @FXML
    private TextField editemailPicker;

    @FXML
    private TextField editinstitutionIDChecker;

    @FXML
    private TextField editnamepicker;

    @FXML
    private PasswordField editpasswordcreate;

    @FXML
    private TextField editpnPicker;

    @FXML
    private Label labelAction;

    @FXML
    private CheckBox othersChecker;

    @FXML
    private CheckBox studentCheck;

    @FXML
    private Button updateButton;

    @FXML
    void UpdateAction(ActionEvent event) {

    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("MyProfilePanel.fxml", event);
    }

}
