package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.*;

public class SignUpPanel {
    @FXML
    private TextField batchPicker;

    @FXML
    private TextField bloodGroupPicker;

    @FXML
    private PasswordField cpassword;

    @FXML
    private TextField departmentPicker;

    @FXML
    private DatePicker dobPicker;

    @FXML
    private TextField emailPicker;

    @FXML
    private TextField institutionIDChecker;

    @FXML
    private Label labelAction;

    @FXML
    private TextField namepicker;

    @FXML
    private CheckBox othersChecker;

    @FXML
    private PasswordField passwordcreate;

    @FXML
    private TextField pnPicker;

    @FXML
    private Button signUpclick;

    @FXML
    private CheckBox studentCheck;

    @FXML
    void signUpAction(ActionEvent event) throws IOException{
        if (studentCheck.isSelected())
        {
            try {
                FileOutputStream fileOutputStream= new FileOutputStream("src/Students_Portal.txt",true);
                ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
                String id= institutionIDChecker.getText();
                int a= id.length();
                if (a==9 && emailPicker.getText()!=null && namepicker.getText()!=null && pnPicker.getText()!=null && bloodGroupPicker.getText()!=null && departmentPicker.getText()!=null && batchPicker.getText()!=null)
                {
                    if (passwordcreate.getText()!=null&&(passwordcreate.getText().equals(passwordcreate.getText())))
                    {
                        My_Profile my_profile= new My_Profile(namepicker.getText(),institutionIDChecker.getText(),passwordcreate.getText(),emailPicker.getText(),pnPicker.getText(),bloodGroupPicker.getText(),departmentPicker.getText(),batchPicker.getText());
                        objectOutputStream.writeObject(my_profile);
                        fileOutputStream.close();
                        objectOutputStream.close();
                        labelAction.setText("New Account created");
                        SceneChanger sceneChanger = new SceneChanger("WelcomePanel.fxml", event);

                    }
                    else {
                        labelAction.setText("Passwords didn't match");
                    }
                }
                else {
                    labelAction.setText("Institute ID must be in 9 digits");
                }
            }
            catch (IOException exc) {
            }
        }
        else if(othersChecker.isSelected())
        {


            try {
                FileOutputStream fileOutputStream= new FileOutputStream("src/Others_Portal.txt",true);
                ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream);
                if (emailPicker.getText()!=null && namepicker.getText()!=null && pnPicker.getText()!=null && batchPicker.getText()!=null )
                {
                    if (passwordcreate.getText()!=null&&(passwordcreate.getText().equals(passwordcreate.getText())))
                    {
                        My_Profile my_profile= new My_Profile(namepicker.getText(),namepicker.getText(),emailPicker.getText(),pnPicker.getText(),bloodGroupPicker.getText());
                        objectOutputStream.writeObject(my_profile);
                        fileOutputStream.close();
                        objectOutputStream.close();
                        labelAction.setText("New Account created");
                        SceneChanger sceneChanger = new SceneChanger("WelcomePanel.fxml", event);
                    }
                    else {
                        labelAction.setText("Password didn't match");
                    }

                }
            }
            catch (IOException exc) {
            }
        }

        }
}