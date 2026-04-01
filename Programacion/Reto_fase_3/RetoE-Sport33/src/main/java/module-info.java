module com.example.retoesport33 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.retoesport33 to javafx.fxml;
    exports com.example.retoesport33;
    exports Controllers;
    opens Controllers to javafx.fxml;
    exports Controllers.VistaEquipo;
    opens Controllers.VistaEquipo to javafx.fxml;
}