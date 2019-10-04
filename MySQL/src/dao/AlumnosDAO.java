package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import src.Alumno;
import src.Conector;

public class AlumnosDAO {
	
	/**
	 * Devuelve una ArrayList con todos los alumnos de la base de datos instanciados
	 * @return ArrayList<Alumno>
	 */
	public static ArrayList<Alumno> obtenerTodos() {
		Conector.getConexion();
		ArrayList<Alumno> alumnado = new ArrayList<Alumno>();
		try {
			Statement sentencia = Conector.getConexion().createStatement();
			String sql = "SELECT * FROM alumnos";
			ResultSet resultado = sentencia.executeQuery(sql);
			
			while (resultado.next()) {
				GregorianCalendar fecha = new GregorianCalendar();
				fecha.setTime(resultado.getDate(3));
				alumnado.add(new Alumno(resultado.getString(1),
						resultado.getString(2),
						fecha,
						resultado.getFloat(4),
						resultado.getInt(5)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return alumnado;
	}
	
	/**
	 * Metodo actualmente inutil
	 * @param resultado
	 * @return
	 * @throws SQLException
	 */
	private static int getColumnas(ResultSet resultado) throws SQLException {
		resultado.last();
		int columnas = resultado.getRow();
		resultado.beforeFirst();
		return columnas;
	}
}//class
