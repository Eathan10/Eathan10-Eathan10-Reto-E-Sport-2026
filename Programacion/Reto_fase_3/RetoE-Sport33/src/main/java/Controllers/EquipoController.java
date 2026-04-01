package Controllers;

import DAO.EquipoDAO;
import Modelo.Equipo;

import java.time.LocalDate;

public class EquipoController {
    public static void insertarEquipo(String nombreEquipo, String codigoEquipo, LocalDate fechaFundacion, int cantidadJugador) {
        Equipo equipo = new Equipo(nombreEquipo, codigoEquipo, fechaFundacion, cantidadJugador);
        EquipoDAO.insertarEquipo(equipo);
    }
}
