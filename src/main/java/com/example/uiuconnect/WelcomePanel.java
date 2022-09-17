package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.IOException;

public class WelcomePanel {
        @FXML
        private Button loginAsOthersButton = new Button();
        @FXML
        private Button loginAsStudentButton = new Button();
        @FXML
        private Button signUpButton = new Button();
        @FXML
        private Button aboutUsButton;

        @FXML
        void accountSignUp(ActionEvent event) throws IOException {
                SceneChanger signUpScene = new SceneChanger("SignUpPanel.fxml", event);
        }
        @FXML
        void othersLogin(ActionEvent event) throws IOException{
                SceneChanger othersScene = new SceneChanger("OthersLoginPanel.fxml", event);
        }
        @FXML
        void studentLogin(ActionEvent event) throws IOException{
                SceneChanger studentScene = new SceneChanger("StudentLoginPanel.fxml", event);
        }
        @FXML
        void AboutAction(ActionEvent event) throws IOException{
                SceneChanger about = new SceneChanger("AboutUsPanel.fxml", event);
        }

}

