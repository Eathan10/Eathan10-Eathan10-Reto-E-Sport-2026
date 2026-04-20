module com.example.retoesport33 {


    requires java.desktop;
    requires java.sql;
    requires javafx.controls;
    requires javafx.fxml;
<<<<<<< Updated upstream
    requires javafx.graphics;
    requires com.example.retoesport33;
<<<<<<< HEAD
=======
    requires java.sql;
>>>>>>> Stashed changes
=======
    requires java.net.http;
>>>>>>> ef850fbb1072ac398b7c203cde94538e6bda7aa6


    opens com.example.retoesport33 to javafx.fxml;
    exports com.example.retoesport33;
    exports Controllers;
    opens Controllers to javafx.fxml;

<<<<<<< HEAD
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
=======
    exports Controllers.Vistas.VistaEquipo;
    opens Controllers.Vistas.VistaEquipo to javafx.fxml;
    exports Controllers.Vistas.VistaAdministradorUsuario;
    opens Controllers.Vistas.VistaAdministradorUsuario to javafx.fxml;
    exports Controllers.Vistas;
    opens Controllers.Vistas to javafx.fxml;
    exports Controllers.Vistas.VistaVer;
    opens Controllers.Vistas.VistaVer to javafx.fxml;
    exports Controllers.Vistas.Jugador;
    opens Controllers.Vistas.Jugador to javafx.fxml;
>>>>>>> ef850fbb1072ac398b7c203cde94538e6bda7aa6

}