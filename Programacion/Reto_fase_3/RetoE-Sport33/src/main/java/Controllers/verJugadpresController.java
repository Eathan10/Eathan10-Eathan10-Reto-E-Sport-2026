package Controllers;

import DAO.JugadorDAO;
import Modelo.Jugador;
import Utilidades.BaseDatos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controlador encargado de gestionar la  visualización de los jugadores, intermediario entre la vista y el dao
 * @author Urko
 * @version 1.0
 * @since 2026-04-19
 */
public class verJugadpresController {

    private JugadorDAO jugadorDao = new JugadorDAO(BaseDatos.getConnection());

    /**
     * obtiene la lista completa de jugadores
     * @return Una lista de objetos jugador con toda la su informacion
     */
    public List<Jugador> getListaParaLaTabla() {
        try {
            return jugadorDao.obtenerTodos();
        }catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
