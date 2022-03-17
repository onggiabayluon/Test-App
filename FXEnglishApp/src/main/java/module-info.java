module com.mycompany.fxenglishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    

    opens com.mycompany.fxenglishapp to javafx.fxml;
    exports com.mycompany.fxenglishapp;
}
