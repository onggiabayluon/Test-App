module com.mycompany.test.app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.test.app to javafx.fxml;
    exports com.mycompany.test.app;
}
