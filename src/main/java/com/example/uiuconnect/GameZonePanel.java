package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;

import java.io.IOException;

public class GameZonePanel {

    @FXML
    private Button exitButton;

    @FXML
    private Button hangmanGameButton;

    @FXML
    private Button snakeGameButton;

    @FXML
    void exitButtonAction(ActionEvent event) throws IOException {
        SceneChanger exit = new SceneChanger("HomePage.fxml", event);
    }

    @FXML
    void hangmanGameAction(ActionEvent event) throws IOException{
        SceneChanger exit = new SceneChanger("Hangman.fxml", event);
    }

    @FXML
    void snakeGameAction(ActionEvent event) {

    }
}