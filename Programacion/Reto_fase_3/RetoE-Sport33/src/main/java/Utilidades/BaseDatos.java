package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {

    static Connection conn;

    public static void connect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            String url = "jdbc:oracle:thin:@172.20.225.144:1521:orcl";
            String user = "eqdaw01";
            String password = "eqdaw01";
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Error en Class.forName " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error al abrir conexion " + e.getMessage());

        }
    }
    public static Connection getConnection() {
        return conn;
    }
}

