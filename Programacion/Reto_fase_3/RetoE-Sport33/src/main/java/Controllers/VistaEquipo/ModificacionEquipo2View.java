package Controllers.VistaEquipo;

import Controllers.EquipoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ModificacionEquipo2View {

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnContinuar;

    @FXML
    private DatePicker dpFechaFundacion;

    @FXML
    private Label lbCodigo;

    @FXML
    private Label lbFecha;

    @FXML
    private Label lbNombre;

    @FXML
    private TextField tfCodigo;

    @FXML
    private TextField tfNombreEquipo;


    @FXML
    void onContinuar(ActionEvent event) {
        String codigoEquipo = tfCodigo.getText();
        String nombreEquipo = tfNombreEquipo.getText();
        LocalDate fechaFundacion = dpFechaFundacion.getValue();

        // para q sean ocpionales, no haga falta escribir nada
        String codigoFinal = codigoEquipo.isEmpty() ? null : codigoEquipo;
        String nombreFinal = nombreEquipo.isEmpty() ? null : nombreEquipo;

        EquipoController.actualizarEquipo(codigoFinal, nombreFinal, fechaFundacion);

    }


    @FXML
    void onVolver(ActionEvent event) {
        controller.show();
        stage.close();

    }


    private ModificarEquipoView controller;
    private Stage stage;

    public void init(String text, Stage stage, ModificarEquipoView modificarEquipoView) {
        lbNombre.setText(text);
        this.controller = modificarEquipoView;
        this.stage = stage;
    }


}
