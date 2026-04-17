package Controllers;
import Controllers.VistaEquipo.EquipoView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;

public class verEquiposView {

    @FXML
    private Button btnVolver;

    @FXML
    private TableColumn<?, ?> tbCodigo;

    @FXML
    private TableColumn<?, ?> tbFechaFundacion;

    @FXML
    private TableColumn<?, ?> tbJugador;

    @FXML
    private TableColumn<?, ?> tbNombre;


    private Stage stage;
    private EquipoView equipoView;


    public void setStage(Stage stage, EquipoView anterior) {
        this.stage = stage;
        this.equipoView = anterior;
    }

    @FXML
    void onVolver(ActionEvent event) {
        if (equipoView != null) {
            equipoView.show();
            this.stage.close();
        } else {
            System.out.println("Error: No se encontró la referencia a la ventana anterior.");
        }
    }

}



