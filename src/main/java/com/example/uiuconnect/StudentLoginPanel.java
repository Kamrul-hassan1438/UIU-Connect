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
    private Button backButton ;

    @FXML
    public static  String id;
    @FXML
    private TextField institutionIDChecker ;

    @FXML
    private Button forgotPasswordButton;

    @FXML
    private Button helpButton;

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordChecker;

    @FXML
    private Label warningLabel;

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
    void loginAction(ActionEvent event) throws IOException{
        try {
            String Id = institutionIDChecker.getText();
            String Pass = passwordChecker.getText();
            Scanner sc = new Scanner(new File("src/Students_Portal.txt"));
            HashMap<String, String> map = new HashMap<>();
            while (sc.hasNext()) {
                String temp = sc.nextLine();
                String[] ar = temp.split("::");
                map.put(ar[0],ar[1]);
                if (map.containsKey(Id)) {
                    String pas;
                    pas = map.get(Id);
                    if (Pass.equals(pas)) {
                        id=Id;
                        try {
                            SceneChanger home_scene = new SceneChanger("HomePage.fxml", event);
                        }
                        catch (IOException e)
                        {

                        }

                    } else {
                        warningLabel.setText("Invalid ID or Password");

                    }}}
            sc.close();
}
    catch ( IOException e){
            e.printStackTrace();
    }
    }
}
