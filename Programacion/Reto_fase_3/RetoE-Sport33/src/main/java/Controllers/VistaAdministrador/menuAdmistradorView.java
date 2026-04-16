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

/**
 * Creacion de la ventana del menu del administrador, para acceder a equipos, jugadores o competicion
 * @author Urko
 * @version 1.0
 * @since 2026-04-15
 */
public class  menuAdmistradorView {

    @FXML
    private Button btnEquipo;

    @FXML
    private Button btnJugador;

    @FXML
    private Button btnCompeticion;

    @FXML
    private Button btnSalir;

    /**
     * metodo para ir a la ventana de equipos
     * @param event Evento de clic en el boton de equipos
     */
    @FXML
    void onEquipo(ActionEvent event) {
        abrirVentana("/vistas/Equipo-view.fxml", "Gestion de Equipo")  ;

    }

    /**
     * metodo para ir a la ventana de jugadores
     * @param event Evento de clic en el boton de jugador
     */
    @FXML
    void onJugador(ActionEvent event) {
        abrirVentana("/vistas/jugadorVista.fxml", "Gestión de Jugadores")  ;
    }

    /**
     * metodo para ir a la ventana de generar competicion
     * @param event Evento de clic en el boton competicion
     */
    @FXML
    void onCompeticion(ActionEvent event) {
        abrirVentana("/vistas/GestionJornada.fxml", "Gestión de Jornadas")  ;
    }

    /**
     * Metodo generico para realizar el cambio de ventanas para los de arriba
     * @param rutaFXML  Ruta del recurso .fxml que se desea cargar
     * @param titulo Texto que se mostrará en la barra superior de la ventana
     */
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

    /**
     * Metodo para  finalizar la ejecucion y sdalir de la ventana
     * @param event Evento de clic en el botón salir
     */
    @FXML
    void onSalir(ActionEvent event) {
        System.exit(0);
    }



    /**
     * Muestra un mensaje de error si ocurre un fallo al cargar una vista
     * @param titulo Título de la alerta
     * @param mensaje texto que aparecera diciendo el error.
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
