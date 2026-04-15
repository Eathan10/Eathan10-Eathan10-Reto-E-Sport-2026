package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Equipo {
    private String NombreEquipo;
    private String CodigoEquipo;
    private LocalDate FechaFundacion;


    //RELACION
    private ArrayList<Jugador> listaJugadores; //1 equipo -- N jugadores



    public Equipo() {
        this.listaJugadores = new ArrayList<>(); // Es buena práctica inicializar la lista aquí
    }

    public Equipo(String nombreEquipo, String codigoEquipo, LocalDate fechaFundacion, ArrayList<Jugador> seleccionados) {
        NombreEquipo = nombreEquipo;
        CodigoEquipo = codigoEquipo;
        FechaFundacion = fechaFundacion;
        setListaJugadores(seleccionados);
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

    public ArrayList<Jugador> getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(ArrayList<Jugador> lista) {
        if (lista != null && lista.size() >= 3 && lista.size() <= 6) {
            this.listaJugadores = lista;
        } else {
            throw new IllegalArgumentException("El equipo debe tener entre 3 y 6 jugadores.");
        }
    }

    public String getNombre() {

        return "";
    }


}
