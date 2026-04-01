package DAO;

import Modelo.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static jdk.internal.org.jline.utils.Colors.s;

public class EquipoDAO {
    public static void insertarEquipo(Equipo equipo) {
        String sql = "INSERT INTO equipos (nombre_equipo, codigo_equipo, fecha_fundacion, cantidad_jugador) VALUES (?, ?, ?, ?)";

        try{
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, equipo.getNombreEquipo());
            ps.setString(2, equipo.getCodigoEquipo());
            ps.setDate(3, java.sql.Date.valueOf(equipo.getFechaFundacion()));

            ps.setInt(4, equipo.getListaJugadores().size());


            ps.executeUpdate();

            System.out.println("Titular insertado correctamente.");
            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
