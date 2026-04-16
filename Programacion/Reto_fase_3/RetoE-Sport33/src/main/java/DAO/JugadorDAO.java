package DAO;

import Modelo.Equipo;
import Modelo.Jugador;
import Utilidades.BaseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JugadorDAO {

    public static void insertarJugador(Jugador jugador) {
        String sql = "INSERT INTO jugadores (cod_jugador, nombre, apellido, nacionalidad," +
                " fecha_nac, nickname, rol, sueldo, cod_equipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, jugador.getCodJugador());
            ps.setString(2, jugador.getNombre());
            ps.setString(3, jugador.getApellido());
            ps.setString(4, jugador.getNacionalidad());
            ps.setDate(5, java.sql.Date.valueOf(jugador.getFechaNac()));
            ps.setString(6, jugador.getNickname());
            ps.setString(7, jugador.getRol());
            ps.setDouble(8, jugador.getSueldo());

            ps.setInt(9, Integer.parseInt(jugador.getEquipo().getCodigoEquipo()));
            ps.executeUpdate();

            BaseDatos.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al insertar jugador." + e.getMessage());
        }
    }

    public void eliminarJugador(String nickname ) throws Exception {
        String sql = "DELETE FROM jugadores WHERE nickname = ?";
        try {
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nickname);
            ps.executeUpdate();

            BaseDatos.closeConnection();
        } catch (Exception e) {
            System.out.println("Jugador eliminado correctamente.");
        }
    }

    public void actualizarJugador(Jugador jugador) {
        String sql = "UPDATE jugadores SET nombre = ?, apellido = ?, nacionalidad = ?, " +
                "fecha_nac = ?, rol = ?, sueldo = ?, cod_equipo = ? WHERE nickname = ?";
        try {
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setString(3, jugador.getNacionalidad());
            ps.setDate(4, java.sql.Date.valueOf(jugador.getFechaNac()));
            ps.setString(5, jugador.getRol());
            ps.setDouble(6, jugador.getSueldo());
            ps.setInt(7, Integer.parseInt(jugador.getEquipo().getCodigoEquipo()));
            ps.setString(8, jugador.getNickname());

            ps.executeUpdate();

            BaseDatos.closeConnection();
        } catch (Exception e) {
            System.out.println("Error al actualizar." + e.getMessage());
        }
    }

    public Jugador buscarJugadorPorNickname(String nickname) throws Exception{
        String sql = "SELECT * FROM jugadores WHERE nickname = ?";
        Jugador jugador = null;
        try {
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, nickname);
            try (
                    ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setCodigoEquipo(String.valueOf(rs.getInt("cod_equipo")));

                    jugador = new Jugador(
                            rs.getInt("cod_jugador"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("nacionalidad"),
                            rs.getDate("fecha_nac").toLocalDate(),
                            rs.getString("nickname"),
                            rs.getString("rol"),
                            rs.getDouble("sueldo"),
                            equipo
                    );
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR. No se encuentra el jugador.");
        }
        return jugador;
    }

    public List<Jugador> obtenerTodos() {
        String sql = "SELECT * FROM jugadores";
        List<Jugador> listaJugadores = new ArrayList<>();
        try (
            Connection conn = BaseDatos.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setCodigoEquipo(String.valueOf(rs.getInt("cod_equipo")));
                    listaJugadores.add(new Jugador(
                            rs.getInt("cod_jugador"),
                            rs.getString("nombre"),
                            rs.getString("apellido"),
                            rs.getString("nacionalidad"),
                            rs.getDate("fecha_nac").toLocalDate(),
                            rs.getString("nickname"),
                            rs.getString("rol"),
                            rs.getDouble("sueldo"),
                            equipo
                    ));
                }
        } catch (Exception e) {
            System.out.println("ERROR. No se encuentran jugadores.");
        }
        return listaJugadores;
    }
}
