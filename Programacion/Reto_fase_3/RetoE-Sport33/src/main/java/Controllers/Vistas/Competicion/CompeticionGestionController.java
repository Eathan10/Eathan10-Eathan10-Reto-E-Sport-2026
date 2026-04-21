package Controllers.Competicion;

import DAO.CompeticionDAO;
import Modelo.Competicion;
import Utilidades.BaseDatos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
<<<<<<< HEAD:Programacion/Reto_fase_3/RetoE-Sport33/src/main/java/Controllers/Competicion/CompeticionGestionController.java
import javafx.scene.control.Alert;
=======
>>>>>>> b734a0f2c531b27a090b7af1f25d6c6952e50927:Programacion/Reto_fase_3/RetoE-Sport33/src/main/java/Controllers/Vistas/Competicion/CompeticionGestionController.java
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class CompeticionGestionController {

    @FXML
    private Button BtnAlta;

    @FXML
    private Button BtnEliminar;

    @FXML
    private Button BtnModificar;

    @FXML
    private Button BtnVolver;

    @FXML
    private TableColumn<Competicion, Integer> colCodigo;

    @FXML
    private TableColumn<Competicion, String> colEstado;

    @FXML
    private TableColumn<Competicion, String> colNombre;

    @FXML
    private TableColumn<Competicion, Double> colPremio;

    @FXML
    private TableView<Competicion> tvCompeticiones;

    private CompeticionDAO competicionDAO;

    @FXML
    private void initialize() {
        competicionDAO = new CompeticionDAO(BaseDatos.getConnection());

        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codComp"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colPremio.setCellValueFactory(new PropertyValueFactory<>("premio"));

        cargarDatos();
    }

    private void cargarDatos() {
        try {
            ObservableList<Competicion> lista = FXCollections.observableArrayList(competicionDAO.listarTodos());
            tvCompeticiones.setItems(lista);
        } catch (SQLException e) {
            e.printStackTrace();
            }
        }

    @FXML
    void onAlta(ActionEvent event) {
        cambiarVentana(event, "/com/example/retoesport33/AltaCompeticion.fxml", "Alta Competición");

    }

@FXML
    void onEliminar(ActionEvent event) {
        cambiarVentana(event , "/com/example/retoesport33/BajaCompeticion.fxml", "Baja Competición");

    }

    @FXML
    void onModificar(ActionEvent event) {
        cambiarVentana(event, "/com/example/retoesport33/ModificarCompeticion.fxml", "Modificar Competición");

    }

    @FXML
    void onVolver(ActionEvent event) {
        cambiarVentana(event, "/com/example/retoesport33/panelPrincipal-view.fxml", "Panel Principal");
    }


private void cambiarVentana(ActionEvent event, String fxml, String titulo) {
    try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
        Parent root = loader.load();
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.setTitle(titulo);
        stage.show();
    } catch (IOException e) {
<<<<<<< HEAD:Programacion/Reto_fase_3/RetoE-Sport33/src/main/java/Controllers/Competicion/CompeticionGestionController.java
        mostrarAlerta(Alert.AlertType.ERROR, "ERROR", "No se encontró la vista" + fxml);
        e.printStackTrace();
    }
}

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String mensaje) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
=======
        System.err.println("Error al cambiar de ventana: " + e.getMessage());
        e.printStackTrace();
    }
}
>>>>>>> b734a0f2c531b27a090b7af1f25d6c6952e50927:Programacion/Reto_fase_3/RetoE-Sport33/src/main/java/Controllers/Vistas/Competicion/CompeticionGestionController.java
}
