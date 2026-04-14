package Controllers.VistaJornada;

import DAO.EquipoDAO;
import Modelo.Equipo;
import Modelo.Jornada;
import Modelo.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class GestionJornadaView {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnGuardar;

    @FXML
    private DatePicker dpFecha;

    @FXML
    private TextField tfMNumeroJornada;

    @FXML
    void onCancelar(ActionEvent event) {

    }

    @FXML
    void onGuardar(ActionEvent event) {
        try{
            // Validar que los campos no estén vacíos
            if (tfMNumeroJornada.getText().isEmpty() || dpFecha.getValue() == null) {
                mostrarAlerta("Campos vacíos", "Por favor, introduce el número de jornada y la fecha.");
                return;
            }

            int numJornada = Integer.parseInt(tfMNumeroJornada.getText());
            LocalDate fecha = dpFecha.getValue();
            Jornada jornadaNueva = new Jornada(numJornada, fecha);

            abrirVentanaPartidos(jornadaNueva);

        }catch(NumberFormatException | IOException e){
            mostrarAlerta("Error de formato", "El número de jornada debe ser un número entero.");
        }

    }


    private void abrirVentanaPartidos(Jornada jornadaNueva) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/partido-view.fxml"));
            Parent root = loader.load();

            Controllers.PartidoController controllerPartidos = loader.getController();
            controllerPartidos.setParentController(this);



            Stage stage = new Stage();
            stage.setTitle("Añadir Partidos - Jornada " + jornadaNueva.getNumJornada());
            stage.setScene(new Scene(root));
            stage.show();

        }catch (IOException e){
            mostrarAlerta("Error al cargar la ventana", "No se pudo abrir la ventana de gestión de partidos.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void agregarPartidoATabla(Partido nuevoPartido) {

    }
}
