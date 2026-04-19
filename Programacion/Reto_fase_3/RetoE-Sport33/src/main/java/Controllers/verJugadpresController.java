package Controllers;

import DAO.JugadorDAO;
import Modelo.Jugador;

import java.util.List;

public class verJugadpresController {

    private JugadorDAO jugadorDao = new JugadorDAO();

    public List<Jugador> getListaParaLaTabla() {
        return jugadorDao.obtenerTodos();
    }
}
