package Controllers.Vistas.Jugador;

import DAO.JugadorDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Optional;

public class BajaJugadorController {

    @FXML
    private Button BtnEliminar;

    @FXML
    private Button BtnVolver;

    @FXML
    private TextField tfNicknameBusqueda;

    private JugadorDAO jugadorDAO;
    private JugadorGestionController jugadorGestionController;

    public void setDatos(JugadorDAO jugadorDAO, JugadorGestionController jugadorGestionController) {
        this.jugadorDAO = jugadorDAO;
        this.jugadorGestionController = jugadorGestionController;
    }

    @FXML
    void onEliminar(ActionEvent event) {
        String nickname = tfNicknameBusqueda.getText().trim();
        if (nickname.isEmpty()) {
            mostrarAlerta(Alert.AlertType.WARNING, "El campo de nickname no puede estar vacío.", "Por favor, ingresa un nickname para eliminar.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("Confirmación de eliminación");
        confirmacion.setHeaderText("¿Estás seguro de que deseas eliminar al jugador con nickname: " + nickname + "?");
        confirmacion.setContentText("Esta acción no se puede deshacer.");

        Optional<ButtonType> resultado = confirmacion.showAndWait();

        if (resultado.isPresent() && resultado.get() == ButtonType.OK) {
            try {
                jugadorDAO.eliminarJugador(nickname);

                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", "Jugador '" + nickname + "' eliminado correctamente.");
                tfNicknameBusqueda.clear();

            } catch (Exception e) {
                mostrarAlerta(Alert.AlertType.ERROR, "Error al eliminar", e.getMessage());
            }
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    void onVolver(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    public void setJugadorDAO(JugadorDAO jugadorDAO) {
    }
}

