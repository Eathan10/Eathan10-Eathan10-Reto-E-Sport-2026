module com.example.retoesport33 {


    requires java.desktop;
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires com.example.retoesport33;


    opens com.example.retoesport33 to javafx.fxml;
    exports com.example.retoesport33;
    exports Controllers;
    opens Controllers to javafx.fxml;

    exports Controllers.VistaEquipo;
    opens Controllers.VistaEquipo to javafx.fxml;
    exports Controllers.VistaAdministradorUsuario;
    opens Controllers.VistaAdministradorUsuario to javafx.fxml;
    exports Controllers.VistaVer;
    opens Controllers.VistaVer to javafx.fxml;

}