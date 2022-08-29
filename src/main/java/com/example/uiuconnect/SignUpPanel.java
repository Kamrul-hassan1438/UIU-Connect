package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
                FileWriter fileWriter= new FileWriter("src/Students_Portal.txt",true);
                BufferedWriter writer= new BufferedWriter(fileWriter);
                String id= institutionIDChecker.getText();
                int a= id.length();
                if (a==9 && emailPicker.getText()!=null && namepicker.getText()!=null && pnPicker.getText()!=null && bloodGroupPicker.getText()!=null && departmentPicker.getText()!=null && batchPicker.getText()!=null)
                {
                    if(passwordcreate.getText().equals(cpassword.getText()))
                    {
                        writer.write("\n"+id+"::"+passwordcreate.getText()+"::"+namepicker.getText()+"::"+emailPicker.getText()+"::"+pnPicker.getText()+"::"+bloodGroupPicker.getText()
                                +"::"+departmentPicker.getText()+"::"+batchPicker.getText());
                        writer.close();
                        labelAction.setText("New Account created");
                        SceneChanger back = new SceneChanger("WelcomePanel.fxml", event);
                    }
                    else {
                        labelAction.setText("Passwords didn't match");
                    }
                }
                else {
                    labelAction.setText("Institute ID must be in 9 digits");
                }
            }
            catch (IOException exc) {}
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
