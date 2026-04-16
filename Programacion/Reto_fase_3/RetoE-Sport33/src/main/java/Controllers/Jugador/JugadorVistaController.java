package Controllers.Jugador;
import DAO.JugadorDAO;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;


public class JugadorVistaController {
    @FXML
    private Button bAlta;

    @FXML
    private Button bBaja;

    @FXML
    private Button bModificar;

    @FXML
    private Button bVolver;

    @FXML
    private ComboBox<?> cbRol;

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
    private TextField tfNombreEquipo;

    @FXML
    private TextField tfSueldo;

    @FXML
    void onAlta(ActionEvent event) {
    }


@FXML
    void onBaja(ActionEvent event) {

}

    @FXML
    void onModificar(ActionEvent event) {

    }

    @FXML
    void onVolver(ActionEvent event) {

    }

    private void mostrarAlerta(String titulo, String contenido, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }



}

