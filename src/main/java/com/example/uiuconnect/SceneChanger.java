package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {
    SceneChanger(String scene_name, ActionEvent e) throws IOException {
        Parent Login = FXMLLoader.load(getClass().getResource(scene_name));
        Scene log_scene= new Scene(Login);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(log_scene);
        window.show();
    }
}
