package Controllers;

import DAO.EquipoDAO;
import Modelo.Equipo;
import Modelo.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;

public class EquipoController {

    private static ArrayList<Jugador> todosLosJugadores = new ArrayList<>();

    public static void añadirJugadorALaListaGeneral(Jugador nuevo) {
        todosLosJugadores.add(nuevo);
    }

    public static void insertarEquipo(String nombreEquipo, String codigoEquipo, LocalDate fechaFundacion, ArrayList<Jugador> seleccionados) {
        Equipo equipo = new Equipo(nombreEquipo, codigoEquipo, fechaFundacion, seleccionados);
        EquipoDAO.insertarEquipo(equipo);
    }

    public static  ArrayList<Jugador>  obtenerTodosLosJugadores() {
        return todosLosJugadores;
    }

    public static void borrarEquipo(String nombreEquipo) {
            EquipoDAO.borrarEquipo(nombreEquipo);
    }

    public static boolean existeEquipo(String nombreEquipo) {
        return EquipoDAO.comprobarExistencia(nombreEquipo);
    }


    public static void actualizarEquipo(String codigoFinal, String nombreFinal, LocalDate fechaFundacion) {
        Equipo equipo = new Equipo(nombreFinal, codigoFinal, fechaFundacion, null);
        EquipoDAO.actualizarEquipo(equipo);
    }
}
