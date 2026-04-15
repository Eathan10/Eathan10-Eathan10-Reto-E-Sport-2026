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

/**
 * Creacion de la ventana del dministrador
 * @author Eathan
 * @version 1.0
 * @since 2026-04-15
 */
public class AdministradorController {

    @FXML
    private Button btnEntrar;

    @FXML
    private TextField tfNombre;

    @FXML
    private TextField tfPassword;

    /**
     * Gestion del boton para iniciar sesion con los datos del administrador
     * @param event Evento de clic en el botón para entrar como administrador
     */
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

    /**
     * Metodo para cargar la siguiente ventana que debe aparecer al darle al boton enter
     */
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

    /**
     * Metodo para mostrar una alerta en caso de que haya algun error al introducir la contraseña y el nombre
     * @param titulo El encabezado de la ventana
     * @param mensaje El mensaje que aparecera dettalando lo ocurrido
     */
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
