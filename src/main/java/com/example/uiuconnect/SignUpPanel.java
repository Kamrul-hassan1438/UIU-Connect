package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

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

    private  int count=0;
    @FXML
    void signUpAction(ActionEvent event) throws IOException{
        if (studentCheck.isSelected())
        {
            try {
                FileWriter fileWriter= new FileWriter("src/Students_Portal.txt",true);
                BufferedWriter writer= new BufferedWriter(fileWriter);
                Scanner sc = new Scanner(new File("src/Students_Portal.txt"));
                HashMap<String, String> map = new HashMap<>();
                String id= institutionIDChecker.getText();
                int a= id.length();
                if (a==9 && emailPicker.getText()!=null && namepicker.getText()!=null && pnPicker.getText()!=null && bloodGroupPicker.getText()!=null && departmentPicker.getText()!=null && batchPicker.getText()!=null)
                {
                    while (sc.hasNext()) {
                        String temp = sc.nextLine();
                        String[] ar = temp.split("::");
                        map.put(ar[0], ar[1]);
                        if (map.containsKey(institutionIDChecker.getText())) {
                            count=1;
                            }
                    }
                        if(count==0 &&passwordcreate.getText().equals(cpassword.getText()))
                        {
                            writer.write("\n"+id+"::"+passwordcreate.getText()+"::"+namepicker.getText()+"::"+emailPicker.getText()+"::"+pnPicker.getText()+"::"+bloodGroupPicker.getText()
                                    +"::"+departmentPicker.getText()+"::"+batchPicker.getText());
                            writer.close();
                            SceneChanger goBack = new SceneChanger("WelcomePanel.fxml", event);
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
                FileWriter fileWriter= new FileWriter("src/Others_Portal.txt",true);
                BufferedWriter writer= new BufferedWriter(fileWriter);
                if (emailPicker.getText()!=null && namepicker.getText()!=null && pnPicker.getText()!=null && bloodGroupPicker.getText()!=null )
                {
                    if (passwordcreate.getText()!=null&&(passwordcreate.getText().equals(cpassword.getText())))
                    {
                        writer.write("\n"+emailPicker.getText()+"::"+passwordcreate.getText()+"::"+namepicker.getText()+"::"+pnPicker.getText()+"::"+bloodGroupPicker.getText());
                        writer.close();
                        labelAction.setText("New Account created");
                        SceneChanger goBack = new SceneChanger("WelcomePanel.fxml", event);
                    }
                    else {
                        labelAction.setText("Password didn't match");
                    }

                }

                writer.close();


            }
            catch (IOException exc) {}
        }


        }
}