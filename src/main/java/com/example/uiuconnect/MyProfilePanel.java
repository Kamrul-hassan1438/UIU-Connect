package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;

import java.io.*;
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
    private Button editButton;

    @FXML
    private ImageView img;
    @FXML
    private Button upload;

    @FXML
    void get_Info(ActionEvent event) throws FileNotFoundException {
        load.setVisible(false);
        if (StudentLoginPanel.id!=null) {
            Scanner sc = new Scanner(new File("src/Students_Portal.txt"));
            HashMap<String, String> map = new HashMap<>();
            while (sc.hasNext()) {
                String temp = sc.nextLine();
                String[] ar = temp.split("::");
                map.put(ar[0], ar[1]);
                if (map.containsKey(StudentLoginPanel.id)) {
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
        else {
            Scanner sc = new Scanner(new File("src/Others_Portal.txt"));
            HashMap<String, String> map = new HashMap<>();
            while (sc.hasNext()) {
                String temp = sc.nextLine();
                String[] ar = temp.split("::");
                map.put(ar[0], ar[1]);
                if (map.containsKey(OthersLoginPanel.Mail))
                {
                    name.setText(ar[2]);
                    email.setText(ar[0]);
                    phone.setText(ar[3]);
                    blood.setText(ar[4]);
                    break;
                }
            }
            sc.close();
        }
    }
    @FXML
    void backButtonAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }

    @FXML
    void editAction(ActionEvent event) throws IOException {
        SceneChanger edit = new SceneChanger("EditMyProfile.fxml", event);
    }

    @FXML
    void get_Img(ActionEvent event) throws IOException {

        FileChooser fc= new FileChooser();
        fc.setInitialDirectory(new File(System.getProperty("user.home")));
        fc.getExtensionFilters().clear();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*png","*jpg"));
        File file=fc.showOpenDialog(null);
        if (file!=null)
        {
            img.setImage(new Image(file.toURL().toString()));
        }
        else {
            System.out.println("A file Invalid");
        }
    }
}
