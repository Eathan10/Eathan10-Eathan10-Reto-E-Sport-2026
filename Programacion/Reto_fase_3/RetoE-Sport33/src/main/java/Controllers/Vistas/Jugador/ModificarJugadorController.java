package Controllers.Vistas.Jugador;

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

public class ModificarJugadorController {

    @FXML
    private Button BtnModificar;

    @FXML
    private Button BtnVolver;

    @FXML
    private Button btnBuscar;

    @FXML
    private ComboBox<String> cbEquipo;

    @FXML
    private ComboBox<String> cbRol;

    @FXML
    private TextField tfApellido;

    @FXML
    private TextField tfBusqueda;

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
    private Jugador jugadorCargador;

    public void setDatos(JugadorDAO jugadorDAO, JugadorGestionController jugadorGestionController) {
        this.jugadorDAO = jugadorDAO;
        this.jugadorGestionController = jugadorGestionController;

        cbRol.setItems(FXCollections.observableArrayList("duelista", "iniciador", "centinela", "controlador"));
        BtnModificar.setDisable(true);
    }

    @FXML
    void onBuscar(ActionEvent event) {
        String busqueda = tfBusqueda.getText();

        if (busqueda.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "Busqueda", "Introduzca un nickname para buscar");
            return;
        }

        try {
            jugadorCargador = jugadorDAO.buscarJugadorPorNickname(busqueda);

            if (jugadorCargador != null) {
                tfNombre.setText(jugadorCargador.getNombre());
                tfApellido.setText(jugadorCargador.getApellido());
                tfNickname.setText(jugadorCargador.getNickname());
                tfNacionalidad.setText(jugadorCargador.getNacionalidad());
                tfNacimiento.setText(jugadorCargador.getFechaNac().toString());
                tfSueldo.setText(String.valueOf(jugadorCargador.getSueldo()));
                cbRol.setValue(jugadorCargador.getRol());
                cbEquipo.setValue(jugadorCargador.getEquipo().getCodigoEquipo());

                BtnModificar.setDisable(false);
                tfNickname.setDisable(false);

            } else {
                mostrarAlerta(Alert.AlertType.ERROR, "Busqueda", "No se encontró ningún jugador con ese nickname");
                limpiarCampos();
            }
        } catch (Exception e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ocurrió un error al buscar el jugador: " + e.getMessage());
        }
    }


    @FXML
    void onModificar(ActionEvent event) {
        if (jugadorCargador == null) {
            mostrarAlerta(Alert.AlertType.WARNING, "Modificar", "Primero busque un jugador para modificar");
            return;
        }

        if (validarCampos()) {
            try {
                jugadorCargador.setNombre(tfNombre.getText());
                jugadorCargador.setApellido(tfApellido.getText());
                jugadorCargador.setNacionalidad(tfNacionalidad.getText());

                try {
                    jugadorCargador.setFechaNac(LocalDate.parse(tfNacimiento.getText()));
                }catch (Exception e) {
                    mostrarAlerta(Alert.AlertType.ERROR, "Error de formato", "La fecha de nacimiento debe estar en formato YYYY-MM-DD");
                    return;
                }
                jugadorCargador.setSueldo(Double.parseDouble(tfSueldo.getText()));
                jugadorCargador.setRol(cbRol.getValue());

                Equipo equipo = new Equipo();
                equipo.setCodigoEquipo(cbEquipo.getValue());
                jugadorCargador.setEquipo(equipo);

                jugadorDAO.actualizarJugador(jugadorCargador);
                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Jugador modificado correctamente");

            } catch (Exception e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error", "Ocurrió un error al modificar el jugador: " + e.getMessage());
            }
        }
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    private boolean validarCampos() {
        if (tfNombre.getText().isEmpty() || tfSueldo.getText().isEmpty() || cbRol.getValue() == null) {
            mostrarAlerta(Alert.AlertType.ERROR, "Validación", "Rellena los campos obligatorios.");
            return false;
        }
        try {
            Double.parseDouble(tfSueldo.getText());
            return true;
        } catch (NumberFormatException e) {
            mostrarAlerta(Alert.AlertType.ERROR, "Validación", "El sueldo debe ser numérico.");
            return false;
        }
    }

    private void limpiarCampos() {
        tfNombre.clear();
        tfApellido.clear();
        tfNickname.clear();
        tfNacionalidad.clear();
        tfNacimiento.clear();
        tfSueldo.clear();
        cbRol.getSelectionModel().clearSelection();
        cbEquipo.getSelectionModel().clearSelection();
        BtnModificar.setDisable(true);
        jugadorCargador = null;
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensagem) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}

