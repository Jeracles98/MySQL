package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {
	
	private static Connection conexion;
	
	private static void conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
//			conexion = DriverManager.getConnection("jdbc:mysql://172.20.254.161/aad_14", "aad_14", "1234");
			conexion = DriverManager.getConnection("jdbc:mysql://iescierva.net:14306/aad_14", "aad_14", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * La primera vez que se ejecuta inicia la conexion
	 * Patron Singleton
	 * @return la conexion a la base de datos
	 */
	public static Connection getConexion() {
		if (conexion == null) {
			conectar();
		}
		return conexion;
	}
	
	public static void cerrarConexion() {
		if (conexion != null) {
			try {
				conexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}//class
