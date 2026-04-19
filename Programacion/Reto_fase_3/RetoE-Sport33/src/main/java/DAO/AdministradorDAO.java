package DAO;


import java.util.Arrays;
import java.util.List;

public class AdministradorDAO {
        private List<String> autorizados = Arrays.asList("fatima", "urko", "eathan", "unax");
        private final String PASS = "1234";

        public boolean validarAcceso(String nombre, String password) {
            return autorizados.contains(nombre.toLowerCase()) && PASS.equals(password);
        }

}
