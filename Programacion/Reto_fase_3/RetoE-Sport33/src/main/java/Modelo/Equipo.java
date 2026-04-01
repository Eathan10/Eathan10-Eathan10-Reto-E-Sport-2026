package Modelo;

import java.time.LocalDate;

public class Equipo {
    private String NombreEquipo;
    private String CodigoEquipo;
    private LocalDate FechaFundacion;
    private int CantidadJugador;

    public Equipo(String nombreEquipo, String codigoEquipo, LocalDate fechaFundacion, int cantidadJugador) {
        NombreEquipo = nombreEquipo;
        CodigoEquipo = codigoEquipo;
        FechaFundacion = fechaFundacion;
        setCantidadJugador(cantidadJugador);
    }


    public String getNombreEquipo() {
        return NombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        NombreEquipo = nombreEquipo;
    }

    public String getCodigoEquipo() {
        return CodigoEquipo;
    }

    public void setCodigoEquipo(String codigoEquipo) {
        CodigoEquipo = codigoEquipo;
    }

    public LocalDate getFechaFundacion() {
        return FechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        FechaFundacion = fechaFundacion;
    }

    public int getCantidadJugador() {
        return CantidadJugador;
    }

    public void setCantidadJugador(int cantidadJugador) {
        if (cantidadJugador > 2 && cantidadJugador <= 6) {
            this.CantidadJugador = cantidadJugador;
        } else {
            throw new IllegalArgumentException("La cantidad de jugadores debe ser entre 2 y 6");
        }
    }


}
