package DAO;

import Modelo.Equipo;
import Modelo.Jugador;
import Utilidades.BaseDatos;

import java.sql.*;
import java.util.List;

public class EquipoDAO {
    public static void insertarEquipo(Equipo equipo) {
        //para el equipo
        String sqlEquipo = "INSERT INTO equipos (nombre_equipo, codigo_equipo, fecha_fundacion) VALUES (?, ?, ?)";
        //para el asignar el equipo al jugaodr
        String sqlJugador = "UPDATE jugadores SET nombre_equipo = ? WHERE nombre_jugador = ?";
        try {
            Connection conn = BaseDatos.getConnection();


            // INSERTAR EQUIPO
            PreparedStatement psE = conn.prepareStatement(sqlEquipo);
            psE.setString(1, equipo.getNombreEquipo());
            psE.setString(2, equipo.getCodigoEquipo());
            psE.setDate(3, java.sql.Date.valueOf(equipo.getFechaFundacion()));
            psE.executeUpdate();
            System.out.println("Equipo insertado con éxito.");


            PreparedStatement psJ = conn.prepareStatement(sqlJugador);
            for (Jugador j : equipo.getJugadores()) {
                psJ.setString(1, equipo.getNombreEquipo()); // Les asignamos este equipo
                psJ.setString(2, j.getNombre());            // Usamos el nombre del jugador para buscarlo
                psJ.executeUpdate();
            }

            System.out.println("Equipo y sus " + equipo.getJugadores().length + " jugadores guardados.");
            BaseDatos.closeConnection();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void borrarEquipo(String nombreEquipo) {
        String sql = "DELETE FROM equipos WHERE nombre_equipo = ?";

        try {
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombreEquipo);

            ps.executeUpdate();

            System.out.println("Equipo borrado correctamente.");
            BaseDatos.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean comprobarExistencia(String nombreEquipo) {
        String sql = "SELECT COUNT(*) FROM equipos WHERE nombre_equipo = ?";

        try {
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nombreEquipo);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int count = rs.getInt(1);
                return count > 0; // Devuelve true si el equipo existe, false si no
            }
            BaseDatos.closeConnection();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }

    public static void actualizarEquipo(Equipo equipo) {
        String sql = "UPDATE equipos SET codigo_equipo = ?, fecha_fundacion = ? WHERE nombre_equipo = ?";

        try {
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, equipo.getCodigoEquipo());
            ps.setDate(2, java.sql.Date.valueOf(equipo.getFechaFundacion()));
            ps.setString(3, equipo.getNombreEquipo());

            ps.executeUpdate();

            System.out.println("Equipo actualizado correctamente.");
            BaseDatos.closeConnection();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
