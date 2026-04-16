module com.example.retoesport33 {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.desktop;
 82f8bca795f439da82601490e1f496a745b8943f
    requires java.sql;


    opens com.example.retoesport33 to javafx.fxml;
    exports com.example.retoesport33;
    exports Controllers;
    opens Controllers to javafx.fxml;

    exports Controllers.VistaEquipo;
    opens Controllers.VistaEquipo to javafx.fxml;
    exports Controllers.VistaAdministrador;
    opens Controllers.VistaAdministrador to javafx.fxml;

}