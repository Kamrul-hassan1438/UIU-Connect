package com.example.uiuconnect;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Launcher extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Launcher.class.getResource("WelcomePanel.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 500);
        stage.setTitle("UIU Connect");
        stage.setScene(scene);
        stage.getIcons().add(new Image("MainLogo.png"));
        stage.show();
        stage.setOnCloseRequest(event ->{
            event.consume();
            Log_out(stage);
        });
        stage.setResizable(false);

    }

    public void Log_out(Stage stage)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Logout");
        alert.setHeaderText("You're about to Logout");
        alert.setContentText("Do You want to save before exiting?:");
        if (alert.showAndWait().get()== ButtonType.OK)
        {
            stage.close();
        }
    }
    public static void main(String[] args) {
        launch();
    }
}