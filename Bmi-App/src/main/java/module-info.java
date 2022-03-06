module com.mycompany.bmi.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.bmi.app to javafx.fxml;
    exports com.mycompany.bmi.app;
}
