package Controllers.VistaAdministrador;

import Utilidades.DatoNoValido;
import Utilidades.Valid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;


public class AdministradorController {

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfPassword;


    @FXML
    void onClickEntrar(ActionEvent event) throws IOException {

        String nombre = tfNombre.getText();
        String password = tfPassword.getText();

        if (Valid.validarDatos(nombre, "^[a-zA-Z]+$") && Valid.validarDatos(password, "^[a-zA-Z0-9]+$")) {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/retoesport33/menuAdministrador-view.fxml"));
            Parent root = loader.load();

            Scene scene = new Scene(root);

            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();

            stage.setScene(scene);
            stage.setTitle("Panel de Administrador");
            stage.show();

        } else {
            mostrarAlerta("Datos incorrectos", "El nombre solo debe contener letras y la contraseña debe ser alfanumérica.");
        }

    }


    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
