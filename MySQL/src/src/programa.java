package src;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.mysql.jdbc.PreparedStatement.ParseInfo;

import dao.AlumnosDAO;

public class programa {


	public static void main(String[] args) throws SQLException {

		Scanner teclado = new Scanner(System.in);
		boolean finalizar = false;
		int opcion;

		while(!finalizar){
			try {
				System.out.println("1.MostrarDatos");
				System.out.println("2.BuscarAlumno");
				System.out.println("3.AñadirAlumno");
				System.out.println("4.BorrarAlumno");
				System.out.println("5.MostrarAlumnosIQ");
				System.out.println("6.finalizar");

				System.out.println("Elige una opción");

				opcion = teclado.nextInt();
				Object query;
				switch(opcion){

				/**
				 * Obtiene a todos los alumnos de la base de datos
				 * e imprime la información por pantalla con el formato
				 * dato - dato - dato etc
				 */
				case 1:
					ArrayList<Alumno> alumnos = AlumnosDAO.obtenerTodos();
					System.out.println("Opción MostrarDatos\n");
					System.out.println("COLUMNAS TABLA ALUMNOS:");
					System.out.println("===================================");
					for (int i = 0; i < alumnos.size(); i++) {
						System.out.println(alumnos.get(i).toString());
					}
					System.out.println("\n");
					break;
				case 2:
					System.out.println("Opción Buscar Alumno");
					System.out.print("Introduce el identificador del alumno a buscar: ");
					String identificador = teclado.next().toUpperCase();
					if ( !identificador.equals("FIN")) {
						Alumno alumno = AlumnosDAO.getAlumnoId(identificador);
						System.out.print("\n"); //Deja un poco de espacio
						if (alumno != null) {
							System.out.println(alumno.toString());
						} else {
							System.out.println("El alumno con id " + identificador + " no existe.");
						}
						//Deja un poco de espacio entre el resultado y la siguiente ejecución
						System.out.println("\n");
					} else {
						break;
					}
				case 3:
					System.out.println("Opción AñadirAlumno");
					Alumno alumnoAux = new Alumno();
					GregorianCalendar fechaAux = new GregorianCalendar();
					int year,month,day;
					System.out.print("Dime la ID del usuario a guardar: ");
					alumnoAux.setIdentificador(teclado.next());
					System.out.print("Dime el Nombre del usuario a guardar: ");
					alumnoAux.setNombre(teclado.next());
					System.out.print("Dime el dia de nacimiento del usuario a guardar: ");
					day = Integer.parseInt(teclado.next());
					System.out.print("Dime el mes de nacimiento del usuario a guardar: ");
					month = Integer.parseInt(teclado.next());
					System.out.print("Dime el año de nacimiento del usuario a guardar: ");
					year = Integer.parseInt(teclado.next());
					fechaAux.set(year, month, day);
					alumnoAux.setFechaNac(fechaAux);
					System.out.print("Dime la calificacion del usuario a guardar: ");
					alumnoAux.setCalificacion(Integer.parseInt(teclado.next()));
					System.out.print("Dime el CI del usuario a guardar: ");
					alumnoAux.setCi(Integer.parseInt(teclado.next()));
					break;
				case 4:
					System.out.println("Opción BorrarAlumno");
					System.out.print("Dime la ID del usuario a borrar");
					identificador = teclado.next();
					if (identificador != null) {
						AlumnosDAO.borrarAlumno(identificador);
					}
				break;
				case 5:
					System.out.println("Opción MostrarAlumnosIQ");
					try
					{
						//construimos la orden SELECT
						//sql= "SELECT * FROM alumnos WHERE coeficiente_de_inteligencia > "+ coeficiente_de_inteligencia +"ORDER BY 1";

						// Preparamos la sentencia
						/*if (valor > coeficiente_de_inteligencia){
					PreparedStatement sentencia = conexion.prepareStatement(sql);
					sentencia.setInt(1,Integer.parseInt((String) coeficiente_de_inteligencia));
					ResultSet rs = sentencia.executeQuery();  
					System.out.println(sql);
					rs.close();// liberar recursos
					sentencia.close();
					}*/

					} catch (Exception e) {e.printStackTrace();}
					break;
				case 6:
					System.out.println("Fin del Programa :D");
					Conector.cerrarConexion();
					finalizar=true;
					break;
				default:

				}
			} catch (InputMismatchException e) {
				System.out.println("\nDebes introducir un numero\n");
				/*Necesito volver a iniciar el teclado, 
				ya que al introducir un dato erroneo se cierra*/
				teclado = new Scanner(System.in);
			}
		}
	}
}



