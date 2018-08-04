package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMysql {
    String driver = "com.mysql.cj.jdbc.Driver";
    String cadena = "jdbc:mysql://localhost:3306/inventario?" +
            "useUnicode=true&" +
            "useJDBCCompliantTimezoneShift=true&" +
            "useLegacyDatetimeCode=false&" +
            "serverTimezone=UTC";
    String usuario = "root";
    String clave = "";

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
