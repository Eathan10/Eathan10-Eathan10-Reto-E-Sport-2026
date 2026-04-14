package Controllers.VistaAdministrador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class  menuAdmistradorView {

    @FXML
    private Button btnEquipo;

    @FXML
    private Button btnJugador;

    @FXML
    private Button btnCompeticion;

    @FXML
    private Button btnSalir;


    @FXML
    void onEquipo(ActionEvent event) {
        abrirVentana("/vistas/Equipo-view.fxml", "Gestion de Equipo")  ;

    }

    @FXML
    void onJugador(ActionEvent event) {
        abrirVentana("/vistas/jugadorVista.fxml", "Gestión de Jugadores")  ;
    }

    @FXML
    void onCompeticion(ActionEvent event) {
        abrirVentana("/vistas/GestionJornada.fxml", "Gestión de Jornadas")  ;
    }

    private void abrirVentana(String rutaFXML, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
            Parent root = loader.load();

            Stage stage = (Stage) btnEquipo.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle(titulo);
            stage.show();

        } catch (IOException e) {
            mostrarAlerta("Error al cargar la ventana", "No se pudo abrir la ventana de Menu del administrador.");
        }
    }

    @FXML
    void onSalir(ActionEvent event) {
        System.exit(0);
    }




    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
   


}
