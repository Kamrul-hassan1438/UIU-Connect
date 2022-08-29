package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class HomePage {
    @FXML
    private Button chitchatButton;

    @FXML
    private Button findFriendsButton;

    @FXML
    private Button gamezoneButton;

    @FXML
    private Button logoutButton;

    @FXML
    private Button myProfileButton;

    @FXML
    void chitchatAction(ActionEvent event) {

    }

    @FXML
    void findFriendsAction(ActionEvent event) {

    }

    @FXML
    void gameZoneAction(ActionEvent event) {

    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        SceneChanger logout = new SceneChanger("WelcomePanel.fxml", event);
    }

    @FXML
    void myProfileAction(ActionEvent event) {

    }
}
