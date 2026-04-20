module com.example.retoesport33 {


    requires java.desktop;
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< Updated upstream
    requires javafx.graphics;
    requires com.example.retoesport33;
=======
    requires java.sql;
>>>>>>> Stashed changes


    opens com.example.retoesport33 to javafx.fxml;
    exports com.example.retoesport33;
    exports Controllers;
    opens Controllers to javafx.fxml;

    exports Controllers.VistaEquipo;
    opens Controllers.VistaEquipo to javafx.fxml;
<<<<<<< Updated upstream
    exports Controllers.VistaAdministradorUsuario;
    opens Controllers.VistaAdministradorUsuario to javafx.fxml;
    exports Controllers.VistaVer;
    opens Controllers.VistaVer to javafx.fxml;
=======
    exports Controllers.Competicion;
    opens Controllers.Competicion to javafx.fxml;
    exports Controllers.Jugador;
    opens Controllers.Jugador to javafx.fxml;
>>>>>>> Stashed changes

}