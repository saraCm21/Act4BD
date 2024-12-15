package conexionBd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
    private static Connection conexion;
    
    public Conexion() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=bd_sara_castellano;encrypt=true;trustServerCertificate=true";
            String usuario = "sara_xyz";
            String contraseña = "sara21082006";
            conexion = DriverManager.getConnection(url, usuario, contraseña);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            System.exit(1);
        }
    }
    
    
    public Connection getConexion() {
    	System.out.println("Conexion exitosa");
        return conexion;
    }

    public void closeConexion() {
        try {
            if (conexion != null) {
            	System.out.println("Conexion cerrada");
                conexion.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }

   
}
