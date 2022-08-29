package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

public class StudentLoginPanel {
    @FXML
    private Button backButton = new Button();

    @FXML
    private TextField institutionIDChecker = new TextField();

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
    void backAction(ActionEvent event) throws IOException{
        SceneChanger back = new SceneChanger("WelcomePanel.fxml", event);
    }


    @FXML
    void forgotPasswordAction(ActionEvent event) {

    }

    @FXML
    void helpAction(ActionEvent event) {

    }

    @FXML
    void loginAction(ActionEvent event) {
        try {
            String Id = institutionIDChecker.getText();
            String Pass = passwordChecker.getText();

            FileInputStream fileInputStream = new FileInputStream(new File("src/Students_Portal.txt"));
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            System.out.println("outside");
            while (objectInputStream.available() != -1) {
                My_Profile my_profile = (My_Profile) objectInputStream.readObject();
                System.out.println(my_profile.name+"   "+my_profile.Password);
                if (my_profile.Password.equals(Pass) && my_profile.ID.equals(Id)) {
                    System.out.println("Inside"+my_profile.name+"  "+my_profile.Password);
                    SceneChanger home_scene = new SceneChanger("HomePage.fxml",event);
                    break;
                } else {
                    warningLabel.setText("Invalid");
                }
            }
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException m) {
            m.printStackTrace();

        }
    }
}
