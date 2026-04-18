package Controllers;

import javafx.event.ActionEvent; // CORRECTO: javafx, no java.awt
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;
import java.io.IOException;

public class verJugadoresView {

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<?, ?> tbApellido;

    @FXML
    private TableColumn<?, ?> tbCodigo;

    @FXML
    private TableColumn<?, ?> tbEquipo;

    @FXML
    private TableColumn<?, ?> tbFechaNac;

    @FXML
    private TableColumn<?, ?> tbNick;

    @FXML
    private TableColumn<?, ?> tbNombre;

    @FXML
    private TableColumn<?, ?> tbRol;

    @FXML
    private TableColumn<?, ?> tbSueldo;



    @FXML
    void onVolver(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/retoesport33/usuario-view.fxml"));
            Parent root = loader.load();

            Stage stage = (Stage) btnVolver.getScene().getWindow();

            stage.setScene(new Scene(root));
            stage.setTitle("Menú de Usuario");
            stage.show();

        } catch (IOException e) {
            mostrarAlerta("Error de Navegación", "No se pudo cargar la ventana de usuario.");
            e.printStackTrace();
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
