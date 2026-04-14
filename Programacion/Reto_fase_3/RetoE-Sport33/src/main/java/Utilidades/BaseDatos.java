package Utilidades;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/bdesport";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static Connection conn = null;

    public static Connection getConnection()  throws Exception{
        conn = DriverManager.getConnection(URL, USER, PASSWORD);
        return conn;
    }

    public static void closeConnection() throws SQLException {
            conn.close();
        }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
