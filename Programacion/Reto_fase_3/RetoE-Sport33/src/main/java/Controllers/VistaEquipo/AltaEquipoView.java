package Controllers.VistaEquipo;

import Controllers.EquipoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class AltaEquipoView {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnSalir;

    @FXML
    private DatePicker dpFechaFundacion;

    @FXML
    private TextField tfCantidadJugador;

    @FXML
    private TextField tfCodigoEquipo;

    @FXML
    private TextField tfNombreEquipo;

    @FXML
    void onAceptar(ActionEvent event) {
        String NombreEquipo = tfNombreEquipo.getText();
        String CodigoEquipo = tfCodigoEquipo.getText();
        LocalDate FechaFundacion = dpFechaFundacion.getValue();
        int CantidadJugador = Integer.parseInt(tfCantidadJugador.getText());



        EquipoController.insertarEquipo(NombreEquipo, CodigoEquipo, FechaFundacion, CantidadJugador);
    }

    @FXML
    void onSalir(ActionEvent event) {

    }

}
