package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class MyProfilePanel {

    @FXML
    private Button backButton;

    @FXML
    private Label blood;

    @FXML
    private Label department;

    @FXML
    private Label dob;

    @FXML
    private Button editMyProfileButton;

    @FXML
    private Button load;

    @FXML
    private Label email;

    @FXML
    private Label name;

    @FXML
    private Label phone;

    @FXML
    void get_Info(ActionEvent event) throws FileNotFoundException {
        load.setVisible(false);
        Scanner sc = new Scanner(new File("src/Students_Portal.txt"));
        HashMap<String, String> map = new HashMap<>();
        while (sc.hasNext()) {
            String temp = sc.nextLine();
            String[] ar = temp.split("::");
            map.put(ar[0],ar[1]);
            if (map.containsKey(StudentLoginPanel.id))
            {
                name.setText(ar[2]);
                email.setText(ar[3]);
                phone.setText(ar[4]);
                blood.setText(ar[5]);
                department.setText(ar[6]);

                break;
            }
        }
        sc.close();
    }
    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }

}
