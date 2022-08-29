package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class OthersLoginPanel {
    @FXML
    private Button backButton = new Button();

    @FXML
    private TextField emailChecker = new TextField();

    @FXML
    private Button forgotPasswordButton = new Button();

    @FXML
    private Button helpButton = new Button();

    @FXML
    private Button loginButton = new Button();

    @FXML
    private PasswordField passwordChecker = new PasswordField();

    @FXML
    private Label warningLabel = new Label();

    @FXML
    void backAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("WelcomePanel.fxml", event);
    }

    @FXML
    void forgotPasswordAction(ActionEvent event) {

    }

    @FXML
    void helpAction(ActionEvent event) {

    }

    @FXML
    void loginAction(ActionEvent event) {

    }

}
