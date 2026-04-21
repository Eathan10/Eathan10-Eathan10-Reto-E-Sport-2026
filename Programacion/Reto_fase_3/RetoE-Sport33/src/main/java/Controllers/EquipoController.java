package Controllers;

import DAO.EquipoDAO;
import Modelo.Equipo;
import Modelo.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


/**
 * Controlador para la gestión de Equipos, tantopara crear equipos, borrarlos o modificarlos, intrermediario entre la vista y el DAO
 * @author Urko
 * @version 1.0
 * @since 2026-04-15
 */
public class EquipoController {

    private static ArrayList<Jugador> todosLosJugadores = new ArrayList<>();

    /**
     * Añade un jugador a la lista temporal de la aplicación
     * @param nuevo Objeto Jugador a añadir
     */
    public static void añadirJugadorALaListaGeneral(Jugador nuevo) {
        todosLosJugadores.add(nuevo);
    }


    /**
     * Crea un objeto Equipo y solicita su inserción en la base de datos a través del DAO
     * @param nombreEquipo Nombre oficial
     * @param codigoEquipo Código único
     * @param fechaFundacion Fecha de creación
     * @param seleccionados Lista de jugadores que forman el equipo
     */
    public static void insertarEquipo(String nombreEquipo, String codigoEquipo, LocalDate fechaFundacion, ArrayList<Jugador> seleccionados) {
        Equipo equipo = new Equipo(nombreEquipo, codigoEquipo, fechaFundacion, seleccionados);
        EquipoDAO.insertarEquipo(equipo);
    }

    public static  ArrayList<Jugador>  obtenerTodosLosJugadores() {
        return todosLosJugadores;
    }

    /**
     * Borra un equipo de la base de datos teniendo en cuenta el nombre del equipo a traves del DAO
     * @param nombreEquipo El nombre del equipo que quieres eliminar
     */
    public static void borrarEquipo(String nombreEquipo) {
            EquipoDAO.borrarEquipo(nombreEquipo);
    }

    /**
     * Para obtener si el equipo que has introducido exte ya en la base de datos mediante su nombre
     * @param nombreEquipo El nombre del equiopo que quieres comprobar si existe
     * @return true si el equipo existe, false si no existe
     */
    public static boolean existeEquipo(String nombreEquipo) {
        return EquipoDAO.comprobarExistencia(nombreEquipo);
    }

    /**
     * Actualizar los datos de los equipos, que exista ya de antemano
     * @param codigoFinal    El codigo actualizado del equipo
     * @param nombreFinal    El nombre actualizado del equipo
     * @param nuevoCodigo      El codigo actualizado del euipo
     * @param fechaFundacion La fecha actualizada del equipo
     */
    public static void actualizarEquipo(String codigoFinal, String nombreFinal, String nuevoCodigo, LocalDate fechaFundacion) {
        Equipo equipo = new Equipo(nombreFinal, codigoFinal, fechaFundacion, null);
        EquipoDAO.actualizarEquipo(equipo);
    }


    /**
     * Metodo para obtener todos los equipos
     * @return los equipos
     */
    public static List<Equipo> listarTodosLosEquipos() {;
        return EquipoDAO.obtenerTodos();
    }

    /**
     * Muestra un JOptionPane con el informe general de los equipos
     */
    public static void mostrarInformeGeneralEquipos() {
        List<Equipo> lista = EquipoDAO.obtenerInformeEquipos();
        StringBuilder sb = new StringBuilder("--- INFORME GENERAL DE EQUIPOS ---\n\n");
        
        for (Equipo e : lista) {
            sb.append("Equipo: ").append(e.getNombreEquipo()).append("\n")
              .append("  Fundación: ").append(e.getFechaFundacion()).append("\n")
              .append("  Nº Jugadores: ").append(e.getNumeroJugadores()).append("\n")
              .append("  Sueldo Máximo: ").append(e.getMaxSueldo()).append("€\n")
              .append("  Sueldo Mínimo: ").append(e.getMinSueldo()).append("€\n")
              .append("  Media Sueldos: ").append(e.getMediaSueldos()).append("€\n")
              .append("--------------------------------------\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString(), "Informe de Equipos", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Muestra un joptionPane con la clasificación de victorias y derrotas
     */
    public static void mostrarClasificacionEquipos() {
        List<Equipo> lista = EquipoDAO.informeVictoriasDerrotas();
        StringBuilder sb = new StringBuilder("--- CLASIFICACIÓN DE EQUIPOS ---\n\n");
        
        for (Equipo e : lista) {
            sb.append("Equipo: ").append(e.getNombreEquipo())
              .append(" | Victorias: ").append(e.getVictorias())
              .append(" | Derrotas: ").append(e.getDerrotas()).append("\n");
        }
        
        JOptionPane.showMessageDialog(null, sb.toString(), "Victorias y Derrotas", JOptionPane.INFORMATION_MESSAGE);
    }
}
