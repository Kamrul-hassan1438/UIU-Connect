module com.example.uiuconnect {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;


    opens com.example.uiuconnect to javafx.fxml;
    exports com.example.uiuconnect;
    exports Snake;
    opens Snake to javafx.fxml;
}