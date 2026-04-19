package Controllers;

import DAO.EquipoDAO;
import Modelo.Equipo;

import java.util.List;

public class verEquiposController {
    private EquipoDAO dao = new EquipoDAO();

    public List<Equipo> getEquiposParaMostrar() {
        return dao.obtenerListaEquipos();
    }
}
