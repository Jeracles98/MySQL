package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	private static Connection conexion;
	
	public static void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection("jdbc:mysql://172.20.254.161/aad_14", "aad_14", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConexion() {
		return conexion;
	}
	
	public static void cerrarConexion() {
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//	// Preparamos la consulta
//		Statement sentencia = conexion.createStatement();
//	      String sql = "SELECT * FROM prueba1";
//		ResultSet resul = sentencia.executeQuery(sql);
}//class
