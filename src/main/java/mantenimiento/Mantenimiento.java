package mantenimiento;

import clases.ConexionMysql;

import java.sql.*;

public class Mantenimiento {
    PreparedStatement sentenciaPreparada;
    ResultSet datos;
    Statement sentencia;

    ConexionMysql mysql = new ConexionMysql();
    Connection conexion = mysql.conexion();

    public boolean insertar(int codigo, String nombre, double precio, int cantidad) {
        String sql = "insert into articulos values(?, ?, ?, ?)";
        try {
            sentenciaPreparada = conexion.prepareStatement(sql);
            sentenciaPreparada.setInt(1, codigo);
            sentenciaPreparada.setString(2, nombre);
            sentenciaPreparada.setDouble(3, precio);
            sentenciaPreparada.setInt(4, cantidad);
            sentenciaPreparada.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public ResultSet consultar(String sql) {
        try {
            String select = sql;
            sentenciaPreparada = conexion.prepareStatement(select);
            datos = sentenciaPreparada.executeQuery();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return datos;
    }

    public void cerrar() {
        try {
            sentenciaPreparada.close();
            sentencia.close();
            datos.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
/*
    public static void main(String[] args) {
        String driver = "org.postgresql.Driver";
        String cadena = "jdbc:postgresql://localhost:5432/inventario?" +
                "useUnicode=true&" +
                "useJDBCCompliantTimezoneShift=true&" +
                "useLegacyDatetimeCode=false&" +
                "serverTimezone=UTC";
        String usuario = "postgres";
        String clave = "123456";

        Connection conexion;

        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(cadena, usuario, clave);
            Statement statement = conexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM articulos");
            //ResultSetMetaData meta = resultSet.getMetaData();
            while (resultSet.next()) {
                System.out.print(resultSet.getInt(1) + " ");
                System.out.print(resultSet.getString(2) + " ");
                System.out.print(resultSet.getDouble(3) + " ");
                System.out.println(resultSet.getInt(4));
            }
        } catch (ClassNotFoundException e) {
            System.out.println("No se encontró el driver...");
        } catch (SQLException e) {
            System.out.println("No se pudo conectar con la base de datos..." + e);
        }

    }
*/
}
