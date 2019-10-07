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
//		Conector.getConexion();
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
	 * Devuelve el alumno con la id que recibe como parametro
	 * @param Id del alumno
	 * @return Alumno con la id
	 */
	public static Alumno getAlumnoId(String id) {
		Alumno alumno;
		try {
			Statement sentencia = Conector.getConexion().createStatement();
			String sql= "SELECT * FROM alumnos WHERE identificador LIKE '" + id + "';";
			ResultSet resultado = sentencia.executeQuery(sql);
			if (resultado.next()) {
				GregorianCalendar fecha = new GregorianCalendar();
				fecha.setTime(resultado.getDate(3));
				alumno = new Alumno(resultado.getString(1),
						resultado.getString(2),
						fecha,
						resultado.getFloat(4),
						resultado.getInt(5));
				return alumno;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/**
	 * Recibe un objeto Alumno y lo añade a la base de datos
	 * @param alumno
	 */
	public static void nuevoAlumno(Alumno alumno) { //He puesto este nombre para evitar problemas con la "ñ" al subirlo a Github
		try {
			if ( getAlumnoId(alumno.getIdentificador()) == null) {
				Statement sentencia = Conector.getConexion().createStatement();
				sentencia.executeUpdate("INSERT INTO alumnos " +
						"(identificador, nombre, fecha_de_nacimiento, calificacion, coeficiente_de_inteligencia) " +
						"VALUES ('" + alumno.getIdentificador() + "', '" + 
						alumno.getNombre() + "', '" + alumno.getFechaNacString() + "', '" + 
						alumno.getCalificacion() + "', '" + alumno.getCi() + "');");
				System.out.println("Usuario guardado exitosamente :D");
			} else {
				System.out.println("Ya existe un usuario con la ID " + alumno.getIdentificador());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void borrarAlumno(String id) {
		try {
			if ( getAlumnoId(id) != null) {
				Statement sentencia = Conector.getConexion().createStatement();
				sentencia.executeUpdate("DELETE FROM alumnos WHERE alumnos.identificador = '" + id + "';");
				System.out.println("Usuario eliminado exitosamente :D");
			} else {
				System.out.println("No existe un usuario con la ID " + id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Metodo que devuelve el numero de resultados de una consulta
	 * @return Integer
	 * @throws SQLException
	 */
	private static int getColumnas(ResultSet resultado) throws SQLException {
		resultado.last();
		int columnas = resultado.getRow();
		resultado.beforeFirst();
		return columnas;
	}
}//class
