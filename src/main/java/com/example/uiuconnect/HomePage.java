package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

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
    private Button YourthoughtsButton;
    @FXML
    private Button uiuBrowser;




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

        SceneChanger myProfile = new SceneChanger("MyProfilePanel.fxml",event);
    }

    @FXML
    void YourThoughtsAction(ActionEvent event) throws IOException{
        SceneChanger yourthoughts = new SceneChanger("YourThoughtsPanel.fxml", event);
    }
    @FXML
    void Your_Thougths(ActionEvent event) throws IOException {
        SceneChanger myProfile = new SceneChanger("YourthoughtsPanel.fxml", event);
    }

    @FXML
    void browserAction(ActionEvent event) throws IOException{
        SceneChanger browserOpen = new SceneChanger("WebViewPanel.fxml", event);
    }
}
