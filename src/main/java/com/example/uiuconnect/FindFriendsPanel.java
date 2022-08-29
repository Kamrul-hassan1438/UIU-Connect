package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class FindFriendsPanel {
    @FXML
    private Button backButton;

    @FXML
    private Button searchButton;

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }

    @FXML
    void searchButtonAction(ActionEvent event) {

    }

}
