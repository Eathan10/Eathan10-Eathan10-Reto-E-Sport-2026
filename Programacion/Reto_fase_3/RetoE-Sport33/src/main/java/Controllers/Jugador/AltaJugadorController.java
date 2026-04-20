package Controllers.Jugador;

import DAO.EquipoDAO;
import DAO.JugadorDAO;
import Modelo.Equipo;
import Modelo.Jugador;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Locale;

public class AltaJugadorController {

    @FXML
    private Button bGuardar;

    @FXML
    private Button bVolver;

    @FXML
    private ComboBox<String> cbEquipo;

    @FXML
    private ComboBox<String> cbRol;

    @FXML
    private TextField tfApellido;

    @FXML
    private TextField tfNacimiento;

    @FXML
    private TextField tfNacionalidad;

    @FXML
    private TextField tfNickname;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfSueldo;

    private JugadorDAO jugadorDAO;
    private JugadorGestionController jugadorGestionController;

    public void setDatos(JugadorDAO jugadorDAO, JugadorGestionController jugadorGestionController) {
        this.jugadorDAO = jugadorDAO;
        this.jugadorGestionController = jugadorGestionController;

        cbRol.setItems(FXCollections.observableArrayList("duelista", "iniciador", "centinela", "controlador"));
    }

    @FXML
    void onGuardar(ActionEvent event) {
        if (validarCampos()) {
            try {
                Equipo equipo = new Equipo();
                equipo.setCodigoEquipo(cbEquipo.getValue());

                Jugador jugador = new Jugador(
                        0,
                        tfNombre.getText(),
                        tfApellido.getText(),
                        tfNacionalidad.getText(),
                        LocalDate.parse(tfNacimiento.getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH)),
                        tfNickname.getText(),
                        cbRol.getValue(),
                        Double.parseDouble(tfSueldo.getText()),
                        equipo
                );

                jugadorDAO.insertarJugador(jugador);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Jugador guardado correctamente.");
                limpiarTodo();

            } catch (DateTimeParseException e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error de Fecha", "El formato de fecha debe ser: AAAA-MM-DD");
            } catch (Exception e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "No se pudo guardar: " + e.getMessage());
            }
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private void limpiarTodo() {
        tfNombre.clear();
        tfApellido.clear();
        tfNickname.clear();
        tfNacionalidad.clear();
        tfNacimiento.clear();
        tfSueldo.clear();
        cbEquipo.getSelectionModel().clearSelection();
        cbRol.getSelectionModel().clearSelection();
    }

    private boolean validarCampos() {
        if (tfNombre.getText().isEmpty() || tfApellido.getText().isEmpty() || tfNickname.getText().isEmpty() ||
                tfNacionalidad.getText().isEmpty() || tfNacimiento.getText().isEmpty() || tfSueldo.getText().isEmpty() ||
                cbEquipo.getValue() == null || cbRol.getValue() == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Validación", "Todos los campos son obligatorios.");
            return false;
        }
        try {
            Double.parseDouble(tfSueldo.getText());
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error de Validación", "El sueldo debe ser un número válido.");
            return false;
        }
        return true;
    }

    public void setJugadorDAO(JugadorDAO jugadorDAO) {
    }
    public void setGestionController(JugadorGestionController jugadorGestionController) {
    }
}

