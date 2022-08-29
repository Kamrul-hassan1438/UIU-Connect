package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
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
    void chitchatAction(ActionEvent event) throws IOException{
        SceneChanger chitchat = new SceneChanger("ChitChatPanel.fxml", event);
    }

    @FXML
    void findFriendsAction(ActionEvent event) throws IOException{
        SceneChanger find = new SceneChanger("FindFriendsPanel.fxml", event);
    }

    @FXML
    void gameZoneAction(ActionEvent event) throws IOException{
        SceneChanger gamezone = new SceneChanger("GameZonePanel.fxml", event);
    }

    @FXML
    void logoutAction(ActionEvent event) throws IOException {
        SceneChanger logout = new SceneChanger("WelcomePanel.fxml", event);
    }

    @FXML
    void myProfileAction(ActionEvent event) throws IOException{
        SceneChanger myProfile = new SceneChanger("MyProfilePanel.fxml", event);
    }
}
