module com.example.uiuconnect {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.uiuconnect to javafx.fxml;
    exports com.example.uiuconnect;
}