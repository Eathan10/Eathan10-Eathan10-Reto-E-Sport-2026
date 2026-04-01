package Controllers.VistaEquipo;

import Controllers.EquipoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.ArrayList;

public class AltaEquipoView {

    @FXML
    private Button btnAceptar;

    @FXML
    private Button btnSalir;

    @FXML
    private DatePicker dpFechaFundacion;

    @FXML
    private ListView<Jugador> lvJugadores;

    @FXML
    private TextField tfCodigoEquipo;

    @FXML
    private TextField tfNombreEquipo;

    @FXML
    public void initialize() {
        // puedan elegir varios jugadores a la vez
        lvJugadores.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        lvJugadores.getItems().addAll(EquipoController.obtenerTodosLosJugadores());
    }

    @FXML
    void onAceptar(ActionEvent event) {
        String NombreEquipo = tfNombreEquipo.getText();
        String CodigoEquipo = tfCodigoEquipo.getText();
        LocalDate FechaFundacion = dpFechaFundacion.getValue();

        ArrayList<Jugador> seleccionados = new ArrayList<>(lvJugadores.getSelectionModel().getSelectedItems());

        if (seleccionados.size() < 3 || seleccionados.size() > 6) {
            System.out.println("Error: Cantidad de jugadores no permitida (" + seleccionados.size() + ")");
            return;
        }



        EquipoController.insertarEquipo(NombreEquipo, CodigoEquipo, FechaFundacion, seleccionados);
    }

    @FXML
    void onSalir(ActionEvent event) {

    }

}
