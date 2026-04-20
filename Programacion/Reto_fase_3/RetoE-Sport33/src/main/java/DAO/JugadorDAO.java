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

    private final Connection conn;

    public JugadorDAO(Connection conn) {
        this.conn = conn;
    }
    public void insertarJugador(Jugador jugador) {
        String sql = "INSERT INTO jugadores (nombre, apellido, nacionalidad," +
                " fecha_nac, nickname, rol, sueldo, cod_equipo) VALUES (?, ?, ?, ?, ?, ?, ?, ? )";
        try (
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setString(3, jugador.getNacionalidad());
            ps.setDate(4, java.sql.Date.valueOf(jugador.getFechaNac()));
            ps.setString(5, jugador.getNickname());
            ps.setString(6, jugador.getRol());
            ps.setDouble(7, jugador.getSueldo());
            ps.setInt(8, Integer.parseInt(jugador.getEquipo().getCodigoEquipo()));
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al insertar jugador." + e.getMessage());
        }
    }

    public void eliminarJugador(String nickname) throws Exception {
        String sql = "DELETE FROM jugadores WHERE nickname = ?";
        try (
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nickname);
            int filas = ps.executeUpdate();
            if (filas == 0) {
                throw new Exception("No se encontró el jugador con el nickname: " + nickname);
            }
        }
    }

    public void actualizarJugador(Jugador jugador) {
        String sql = "UPDATE jugadores SET nombre = ?, apellido = ?, nacionalidad = ?, " +
                "fecha_nac = ?, rol = ?, sueldo = ?, cod_equipo = ? WHERE nickname = ?";
        try (
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, jugador.getNombre());
            ps.setString(2, jugador.getApellido());
            ps.setString(3, jugador.getNacionalidad());
            ps.setDate(4, java.sql.Date.valueOf(jugador.getFechaNac()));
            ps.setString(5, jugador.getRol());
            ps.setDouble(6, jugador.getSueldo());
            ps.setInt(7, Integer.parseInt(jugador.getEquipo().getCodigoEquipo()));
            ps.setString(8, jugador.getNickname());

            ps.executeUpdate();
            System.out.println("Jugador modificado correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al modificar jugador: " + e.getMessage());
        }
    }


    public Jugador buscarJugadorPorNickname(String nickname) throws Exception{
        String sql = "SELECT * FROM jugadores WHERE nickname = ?";
        try (
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, nickname);
            try (
                    ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Equipo equipo = new Equipo();
                    equipo.setCodigoEquipo(String.valueOf(rs.getInt("cod_equipo")));
                    return new Jugador(
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
        }

        return null;
    }

    public List<Jugador> obtenerTodos() {
        String sql = "SELECT * FROM jugadores";
        List<Jugador> listaJugadores = new ArrayList<>();
        try (
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
