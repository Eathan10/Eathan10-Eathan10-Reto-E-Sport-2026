package Controllers.VistaJornada;

import Controllers.EquipoController;
import DAO.EquipoDAO;
import Modelo.Equipo;
import Modelo.Partido;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.Collections;
import java.util.List;

public class PartidoController {

    @FXML
    private Label lbfecha;

    @FXML
    private Label lbhora;

    @FXML
    private Label lblocal;

    @FXML
    private Label lbprediccion;

    @FXML
    private Label lbresultadolocal;

    @FXML
    private Label lbresultadovisitante;

    @FXML
    private Label lbvisitante;

    private EquipoDAO equipoDAO = new EquipoDAO();

    @FXML
    public void initialize() {
        generarEnfrentamientosAutomaticos();
    }

    private void generarEnfrentamientosAutomaticos() {


        List<Equipo> todosLosEquipos = EquipoController.listarTodosLosEquipos();

        Collections.shuffle(todosLosEquipos);// mezcalrlos para q sean aleatorios los emparejamenntos


        if (todosLosEquipos.size() >= 2) {// de dos en dos los emparejamientos
            Equipo local = todosLosEquipos.get(0);
            Equipo visitante = todosLosEquipos.get(1);

            lblocal.setText(local.getNombreEquipo());
            lbvisitante.setText(visitante.getNombreEquipo());

            lbprediccion.setText(predecirGanadorIA(local, visitante));
        }

    }

    private String predecirGanadorIA(Equipo local, Equipo visitante) {
        return "";
    }


}


