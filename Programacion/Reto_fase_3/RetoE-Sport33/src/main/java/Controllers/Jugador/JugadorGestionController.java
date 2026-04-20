package Controllers.Jugador;

import DAO.JugadorDAO;
import Modelo.Jugador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class JugadorGestionController {

    private JugadorDAO jugadorDAO;

    public void setJugadorDAO(JugadorDAO jugadorDAO) {
        this.jugadorDAO = jugadorDAO;
    }

    @FXML
    private Button BtnAlta;

    @FXML
    private Button BtnBorrar;

    @FXML
    private Button BtnModificar;

    @FXML
    private Button Btnvolver;

    private BorderPane panelPrincipal;

    @FXML
    void onAlta(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/Jugador/AltaJugador.fxml"));
        Parent vista = loader.load();
        AltaJugadorController ctrl = loader.getController();
        ctrl.setJugadorDAO(jugadorDAO);
        ctrl.setGestionController(this);
        panelPrincipal.setCenter(vista);

    }

    @FXML
    void onBorrar(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/Jugador/AltaJugador.fxml"));
        Parent vista = loader.load();
        BajaJugadorController ctrl = loader.getController();
        ctrl.setJugadorDAO(jugadorDAO);
        panelPrincipal.setCenter(vista);

    }

    @FXML
    void onModificar(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Controllers/Jugador/AltaJugador.fxml"));
        Parent vista = loader.load();
        ModificarJugadorController ctrl = loader.getController();
        ctrl.setJugadorDAO(jugadorDAO);
        panelPrincipal.setCenter(vista);
    }

    @FXML
    void onVolver(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PanelPrincipal.fxml"));
        Parent vista = loader.load();
        ModificarJugadorController ctrl = loader.getController();
        ctrl.setJugadorDAO(jugadorDAO);
        panelPrincipal.setCenter(vista);
    }
}