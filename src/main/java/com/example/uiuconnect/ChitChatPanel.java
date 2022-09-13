package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ChitChatPanel {

    @FXML
    private Button SendButton;

    public static String username;
    @FXML
    private TextArea all_text;
    @FXML
    private TextField message;
    @FXML
    private Button backButton;

    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }

    @FXML
    void sendButtonAction(ActionEvent event) {

    }

}
