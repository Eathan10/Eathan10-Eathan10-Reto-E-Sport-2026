package Test;

import Modelo.Equipo;
import Modelo.Jugador;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EquipoTest {
    @Test
    void testCrearEquipoCorrecto() {
        ArrayList<Jugador> jugadores = new ArrayList<>();

        jugadores.add(new Jugador(1, "A", "B", "C", LocalDate.now(), "N1", "R", 1000, null));
        jugadores.add(new Jugador(2, "D", "E", "F", LocalDate.now(), "N2", "R", 1000, null));
        jugadores.add(new Jugador(3, "G", "H", "I", LocalDate.now(), "N3", "R", 1000, null));

        LocalDate fecha = LocalDate.of(2020, 1, 1);
        Equipo e = new Equipo("G2 Esports", "G2", fecha, jugadores);

        assertEquals("G2 Esports", e.getNombreEquipo());
        assertEquals("G2", e.getCodigoEquipo());
        assertEquals(3, e.getListaJugadores().size());
    }

    @Test
    void testEquipoInvalido() {
        ArrayList<Jugador> pocosJugadores = new ArrayList<>();
        pocosJugadores.add(new Jugador(1, "A", "B", "C", LocalDate.now(), "N1", "R", 1000, null));

        assertThrows(IllegalArgumentException.class, () -> {
            new Equipo("Fallo", "F1", LocalDate.now(), pocosJugadores);
        });
    }

}