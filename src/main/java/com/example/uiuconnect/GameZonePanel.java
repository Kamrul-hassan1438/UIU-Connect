package com.example.uiuconnect;

import Snake.SnakeMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
        SceneChanger exit = new SceneChanger("Hang_s.fxml", event);
    }

    @FXML
    void snakeGameAction(ActionEvent event) {
        SnakeMain snakeMain= new SnakeMain();
        snakeMain.start(new Stage());
    }
}