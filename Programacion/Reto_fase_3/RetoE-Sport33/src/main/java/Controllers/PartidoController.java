package Controllers;

import javafx.fxml.FXML;

import java.lang.classfile.Label;

import Modelo.*;

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
    private Label lbvisitante;

    public void setPartido(Partido partido){
        lbLocal.setText(partido.getEquipoLocal());
        lblVisitante.setText(partido.getEquipoVisitante());
        lblFecha.setText(partido.getFecha().toString());
        lblHora.setText(partido.getHora().toString());
        lblPrediccion.setText();

    }


}
