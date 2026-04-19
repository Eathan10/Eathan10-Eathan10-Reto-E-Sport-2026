package Modelo;

public class Administrador {
    private String nombre;
    private String password;

    public Administrador(String nombre, String password) {
        this.nombre = nombre;
        this.password = password;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getPassword() { return password; }
}