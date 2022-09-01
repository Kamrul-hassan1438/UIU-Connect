package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class MyProfilePanel {
    @FXML
    private Button backButton;

    @FXML
    private Button editMyProfileButton;

    @FXML
    void backAction(ActionEvent event) throws IOException {
        SceneChanger back= new SceneChanger("HomePage.fxml", event);

    }

    @FXML
    void editMyProfileAction(ActionEvent event) {

    }

}
