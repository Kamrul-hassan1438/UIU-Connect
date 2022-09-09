package com.example.uiuconnect;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WebViewPanel implements Initializable {

    @FXML
    private Button back;

    @FXML
    private TextField search;

    @FXML
    private Button searchButton;

    @FXML
    private WebView webview;

    private WebEngine engine;

    @FXML
    void backAction(ActionEvent event) throws IOException {
        SceneChanger back = new SceneChanger("HomePage.fxml", event);
    }

    @FXML
    void searchAction() {
        engine.load("http://"+ search.getText());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = webview.getEngine();
        String homePage = "www.uiu.ac.bd";
        search.setText(homePage);
        searchAction();
    }

    public void reloadAction(){
        engine.reload();
    }

    public void webViewAction(MouseEvent mouseEvent) {
    }
}
