package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionPsql {
    String driver = "org.postgresql.Driver";
    String cadena = "jdbc:postgresql://localhost:5432/inventario?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC";
    String usuario = "postgres";
    String clave = "123456";

    Connection conexion;


    public Connection conexion() {
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(cadena, usuario, clave);
        }catch (ClassNotFoundException e){
            System.out.println("No se encontró el driver...");
        }catch (SQLException e){
            System.out.println("No se pudo conectar con la base de datos...");
        }
        return conexion;
    }
}
