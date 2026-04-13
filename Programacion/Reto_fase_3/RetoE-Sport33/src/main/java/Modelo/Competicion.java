package Modelo;

public class Competicion {
    private int codComp;
    private String nombre;
    private String estado;
    private String premio;

    public Competicion(int codComp, String nombre, String estado, String premio) {
        this.codComp = codComp;
        this.nombre = nombre;
        this.estado = estado;
        this.premio = premio;
    }

    public int getCodComp() {
        return codComp;
    }

    public void setCodComp(int codComp) {
        this.codComp = codComp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }

    @Override
    public String toString() {
        return "Competicion{" +
                "codComp=" + codComp +
                ", nombre='" + nombre + '\'' +
                ", estado='" + estado + '\'' +
                ", premio='" + premio + '\'' +
                '}';
    }
}
