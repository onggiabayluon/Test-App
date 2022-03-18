module com.mycompany.fxenglishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
//    requires org.junit.jupiter.api;
    requires java.base;
    

    opens com.mycompany.fxenglishapp to javafx.fxml;
    exports com.mycompany.fxenglishapp;
    exports com.mycompany.conf;
}
