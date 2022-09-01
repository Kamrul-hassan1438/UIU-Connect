package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Scanner;

public class OthersLoginPanel {
    @FXML
    private Button backButton = new Button();

    @FXML
    private TextField emailChecker = new TextField();

    @FXML
    private Button forgotPasswordButton = new Button();

    @FXML
    private Button helpButton = new Button();

    @FXML
    private Button loginButton = new Button();

    @FXML
    private PasswordField passwordChecker = new PasswordField();

    @FXML
    private Label warningLabel = new Label();

    @FXML
    void backAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("WelcomePanel.fxml", event);
    }

    @FXML
    void forgotPasswordAction(ActionEvent event) {

    }

    @FXML
    void helpAction(ActionEvent event) {

    }

    @FXML
    void loginAction(ActionEvent event) throws IOException {
        try {
            String useremail = emailChecker.getText();
            String Pass = passwordChecker.getText();
            Scanner sc = new Scanner(new File("src/Others_Portal.txt"));
            HashMap<String, String> map = new HashMap<>();

            while (sc.hasNext()) {
                String temp = sc.nextLine();
                String[] ar = temp.split("::");
                map.put(ar[0], ar[1]);
                if (map.containsKey(useremail)) {
                    String pas;
                    pas = map.get(useremail);
                    if (Pass.equals(pas)) {
                        SceneChanger home_scene = new SceneChanger("HomePage.fxml", event);
                    } else {
                        warningLabel.setText("Invalid email or Password");
                    }
                    break;
                } else {
                    warningLabel.setText("Invalid email or Password");
                }
            }
            sc.close();
        } catch (IOException m) {

        }
    }
}
