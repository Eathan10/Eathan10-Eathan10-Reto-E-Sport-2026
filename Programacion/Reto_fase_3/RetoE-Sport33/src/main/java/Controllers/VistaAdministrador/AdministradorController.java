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
    void onClickEntrar(ActionEvent event) {

        String nombre = tfNombre.getText();
        String password = tfPassword.getText();

        if (Valid.validarDatos(nombre, "^[a-zA-Z]+$") && Valid.validarDatos(password, "^[a-zA-Z0-9]+$")) {
            throw new DatoNoValido("Nombre de administrador o contraseña incorrectos");
        } else {
            JOptionPane.showMessageDialog(null, "Datos correctos");
        }


        menuAdministrador();
    }

    // para cargar la ventana de menu del admin. Cone3ctar ventanas
    private void menuAdministrador() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vistas/menuAdministrador-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnEntrar.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Panel de Administración");
            stage.show();

        } catch (IOException e) {
            mostrarAlerta("Error al cargar la ventana", "No se pudo abrir la ventana de Menu del administrador.");
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
