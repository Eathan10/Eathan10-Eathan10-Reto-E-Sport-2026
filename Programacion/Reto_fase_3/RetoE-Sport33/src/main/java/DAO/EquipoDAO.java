package DAO;

import Modelo.Equipo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

    public static void borrarEquipo(String nombreEquipo) {
        String sql = "DELETE FROM equipos WHERE nombre_equipo = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombreEquipo);

            ps.executeUpdate();

            System.out.println("Equipo borrado correctamente.");
            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean comprobarExistencia(String nombreEquipo) {
        String sql = "SELECT COUNT(*) FROM equipos WHERE nombre_equipo = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombreEquipo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devuelve true si el equipo existe, false si no
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void actualizarEquipo(Equipo equipo) {
        String sql = "UPDATE equipos SET codigo_equipo = ?, fecha_fundacion = ? WHERE nombre_equipo = ?";

        try {
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, equipo.getCodigoEquipo());
            ps.setDate(2, java.sql.Date.valueOf(equipo.getFechaFundacion()));
            ps.setString(3, equipo.getNombreEquipo());

            ps.executeUpdate();

            System.out.println("Equipo actualizado correctamente.");
            DBConnection.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Equipo> obtenerTodos() {
    }
}
