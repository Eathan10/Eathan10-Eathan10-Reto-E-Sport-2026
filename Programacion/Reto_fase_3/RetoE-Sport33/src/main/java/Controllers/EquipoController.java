package Controllers;

import DAO.EquipoDAO;
import Modelo.Equipo;

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
}
