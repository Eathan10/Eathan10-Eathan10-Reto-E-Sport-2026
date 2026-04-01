package Controllers.VistaEquipo;

import Controllers.EquipoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ModificarEquipoView {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Label lb;

    @FXML
    private Label lbNo;

    @FXML
    private TextField tfNombreEquipo;

    @FXML
    void onAceptar(ActionEvent event) throws IOException {
        String NombreEquipo = tfNombreEquipo.getText().trim();

        if (NombreEquipo.isEmpty()) {
            mostrarAlertaError("Campo obligatorio", "El nombre del equipo no puede estar vacío.");
            return;
        }

        boolean existe = EquipoController.existeEquipo(NombreEquipo);

        if (!existe) {
            mostrarAlertaError("Equipo no encontrado", "No existe ningún equipo con el nombre: " + NombreEquipo);
            return;
        }

        if (confirmarAccion("¿Estás seguro de que deseas borrar el equipo: " + NombreEquipo + "?")) {
            limpiarcajas();
        }

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/org/example/RetoE-Sport33/ModificarEquipo2-view.fxml"));
        Parent root = fxmlLoader.load();


        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setTitle("Ventana dos");
        stage.setScene(scene);

        ModificacionEquipo2View controller2 = fxmlLoader.getController();

        controller2.init(tfNombreEquipo.getText(),stage,this);

        stage.show();
        this.stage.close();
    }




    private Stage stage;

    public void setStage(Stage stage) {
        // Establece la ventana actual
        this.stage = stage;
    }


    public void show() {
        // Muestra la ventana
        stage.show();
    }


    @FXML
    void onCancelar(ActionEvent event) {

    }


    private boolean confirmarAccion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar acción");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        return alert.showAndWait().filter(r -> r == ButtonType.OK).isPresent();
    }

    // para mensaje de cuadro de error
    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }


    // para q se limpie lo escrito dentro de la caja
    @FXML
    private void limpiarcajas(){
        tfNombreEquipo.clear();
    }

}
