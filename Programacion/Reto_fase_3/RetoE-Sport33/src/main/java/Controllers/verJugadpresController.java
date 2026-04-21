package Controllers;

import DAO.JugadorDAO;
import Modelo.Jugador;
import Utilidades.BaseDatos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

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

    /**
     * Muestra un JOptionPane con los jugadores de un equipo en concreto
     * @param nombreEquipo El nombre del equipo que se quiere consultar
     */
    public void mostrarInformeJugadoresPorEquipo(String nombreEquipo) {
        // Aprovechamos el jugadorDao que ya está instanciado en esta clase
        List<Jugador> lista = jugadorDao.obtenerInformeJugadores(nombreEquipo);
        StringBuilder sb = new StringBuilder("--- JUGADORES DEL EQUIPO: ").append(nombreEquipo.toUpperCase()).append(" ---\n\n");
        
        if(lista.isEmpty()){
            sb.append("No se han encontrado jugadores para este equipo.");
        } else {
            for (Jugador j : lista) {
                sb.append("Nombre: ").append(j.getNombre()).append(" ").append(j.getApellido()).append("\n")
                  .append("  Rol: ").append(j.getRol()).append("\n")
                  .append("  Sueldo: ").append(j.getSueldo()).append("€\n")
                  .append("--------------------------------------\n");
            }
        }
        
        JOptionPane.showMessageDialog(null, sb.toString(), "Informe de Jugadores", JOptionPane.INFORMATION_MESSAGE);
    }
}
