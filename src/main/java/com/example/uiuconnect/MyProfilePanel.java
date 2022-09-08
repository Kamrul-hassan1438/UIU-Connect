package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
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
    private Label email;

    @FXML
    private Label name;

    @FXML
    private Label phone;

    @FXML
    void action(ActionEvent event)
    {
        try {
            Scanner sc = new Scanner(new File("src/Students_Portal.txt"));

            while (sc.hasNext()) {
                String temp=sc.nextLine();
                String []arg= temp.split("::");
                if (arg[0].equals(StudentLoginPanel.id))
                {
                    name.setText(arg[2]);
                    email.setText(arg[3]);
                    phone.setText(arg[4]);
                    blood.setText(arg[5]);
                    department.setText(arg[6]);
                }
            }
            sc.close();

        }
        catch (IndexOutOfBoundsException | FileNotFoundException e)
        {

        }
    }

    @FXML
    void backAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }

}
