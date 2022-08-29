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
    void loginAction(ActionEvent event) throws IOException{
        try {
            String useremail= emailChecker.getText();
            String Pass=passwordChecker.getText();
            FileInputStream fileInputStream= new FileInputStream(new File("src/Others_Portal.txt"));
            ObjectInputStream objectInputStream= new ObjectInputStream(fileInputStream);

            System.out.println(useremail);
            while (objectInputStream.available()!=-1)
            {
                My_Profile my_profile = (My_Profile)objectInputStream.readObject();
                if (my_profile.Mail.equals(useremail) && my_profile.Password.equals(Pass)){
                    SceneChanger home_scene = new SceneChanger("HomePage.fxml",event);
                    break;
                }
                else {
                    warningLabel.setText("Invalid");
                }
            }
            fileInputStream.close();
            objectInputStream.close();
        }
        catch (IOException m)
        {

        } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

}
