package Test;

import Modelo.Perfil;

import static org.junit.jupiter.api.Assertions.*;

class PerfilTest {

    @Test
    void testCrearPerfil() {

        // objeto de prueba
        Perfil p = new Perfil(1, "admin", "1234", "ADMIN");


        assertEquals(1, p.getCodPerfil());
        assertEquals("admin", p.getNombre());
        assertEquals("1234", p.getPassword());
        assertEquals("ADMIN", p.getTipo());
    }

    @Test
    void testSetters() {
        Perfil p = new Perfil(0, "", "", "");
        p.setNombre("Urko");
        assertEquals("Urko", p.getNombre());
    }

}