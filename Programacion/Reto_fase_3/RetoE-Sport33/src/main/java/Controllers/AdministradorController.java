package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdministradorController {

    @FXML
    private Button Bentrar;

    @FXML
    private TextField TFnombre;

    @FXML
    private TextField TFpassword;

    @FXML
    void onClickEntrar(ActionEvent event) {
        System.out.println(TFnombre.getText());
    }
}
