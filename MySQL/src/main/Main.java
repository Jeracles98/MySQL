package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import src.Conector;

public class Main {

	public static void main(String[] args) {
		Conector.conectar();
		
		try {
			Statement sentencia = Conector.getConexion().createStatement();
			String sql = "SELECT * FROM alumnos";
			ResultSet resultado = sentencia.executeQuery(sql);
			
			while (resultado.next()) {
			    System.out.printf("%s, %s, %s , %f, %d  %n", 
			    		resultado.getString(1), 
			    		resultado.getString(2), 
			    		resultado.getDate(3),
			    		resultado.getFloat(4),
			    		resultado.getInt(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		Conector.cerrarConexion();
	}

}
