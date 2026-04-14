package Controllers.VistaJornada;

import DAO.EquipoDAO;
import Modelo.Equipo;
import Modelo.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

import java.util.List;

public class PartidoController {

    @FXML
    private Button btnAñadir;

    @FXML
    private ComboBox<Equipo> cbLocal;

    @FXML
    private ComboBox<Equipo> cbVisitante;

    @FXML
    private TextField tfhora;

    // referencia a la tabla jornada
    private GestionJornadaView parentController;

    public void setParentController(GestionJornadaView parent) {
        this.parentController = parent;
    }

    @FXML
    public void initialize() {
        List<Equipo> listaEquipos = EquipoDAO.obtenerTodos();

        ObservableList<Equipo> items = FXCollections.observableArrayList(listaEquipos);
        cbLocal.setItems(items);
        cbVisitante.setItems(items);

        StringConverter<Equipo> converter = new StringConverter<Equipo>() {
            @Override
            public String toString(Equipo equipo) {
                return (equipo == null) ? "" : equipo.getNombre();
            }

            @Override
            public Equipo fromString(String string) {
                return null;
            }
        };

        cbLocal.setConverter(converter);
        cbVisitante.setConverter(converter);
    }

    @FXML
    void onAñadir(ActionEvent event) {
        Equipo local = cbLocal.getValue();
        Equipo visitante = cbVisitante.getValue();
        String hora = tfhora.getText();

        if (local == null || visitante == null || hora.isEmpty()) {
            mostrarAlerta("Campos incompletos", "Por favor, selecciona ambos equipos e introduce una hora.");
            return;
        }

        if (local.equals(visitante)) {
            mostrarAlerta("Error de selección", "Un equipo no puede jugar contra sí mismo. Elige equipos diferentes.");
            return;
        }

        Partido nuevoPartido = new Partido(hora, local, visitante);

        if (parentController != null) {
            parentController.agregarPartidoATabla(nuevoPartido);

            mostrarAlerta("Éxito", "Partido añadido a la jornada.");

            cbLocal.setValue(null);
            cbVisitante.setValue(null);
            tfhora.clear();
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


