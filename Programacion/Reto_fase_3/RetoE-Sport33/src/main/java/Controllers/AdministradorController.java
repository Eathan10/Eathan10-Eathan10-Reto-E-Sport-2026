package Controllers;

import Utilidades.DatoNoValido;
import Utilidades.Valid;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;

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

        if (!Valid.validarDatos(nombre, "^[a-zA-Z]+$") && Valid.validarDatos(password, "^[a-zA-Z0-9]+$")) {
            throw new DatoNoValido("Nombre de administrador o contraseña incorrectos");
        } else {
            JOptionPane.showMessageDialog(null, "Datos correctos");
        }

    }
}
