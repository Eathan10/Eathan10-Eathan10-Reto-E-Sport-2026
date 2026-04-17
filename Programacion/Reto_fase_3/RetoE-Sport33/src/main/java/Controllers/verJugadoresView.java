package Controllers;

import java.awt.event.ActionEvent;

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

    // Referenciass a la ventana anterior
    private Stage stage;
    private MenuUsuarioController menuUsuarioController;


    public void setStage(Stage stage, MenuUsuarioController anterior) {
        this.stage = stage;
        this.menuUsuarioController = anterior;
    }

    @FXML
    void onVolver(ActionEvent event) {

        if (menuUsuarioController != null) {
            menuUsuarioController.show();
            this.stage.close();
        }
    }
}
