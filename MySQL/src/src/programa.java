package src;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;



import dao.AlumnosDAO;

public class programa {


	public static void main(String[] args) throws SQLException {

		@SuppressWarnings("resource")
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
				switch(opcion){

				/**
				 * Obtiene a todos los alumnos de la base de datos
				 * e imprime la información por pantalla con el formato
				 * dato - dato - dato etc
				 */
				case 1:
					ArrayList<Alumno> alumnosC1 = AlumnosDAO.obtenerTodos();
					System.out.println("Opción MostrarDatos\n");
					System.out.println("COLUMNAS TABLA ALUMNOS:");
					System.out.println("===================================");
					for (int i = 0; i < alumnosC1.size(); i++) {
						System.out.println(alumnosC1.get(i).toString());
					}
					System.out.println("\n");
					break;
				case 2:
					System.out.println("Opción Buscar Alumno");
					String identificador = "";
					while (!identificador.equals("FIN")) {
						System.out.print("Introduce el identificador del alumno a buscar\nO introduce FIN para acabar");
						identificador = teclado.next().toUpperCase();
						Alumno alumno = AlumnosDAO.getAlumnoId(identificador);
						System.out.print("\n"); //Deja un poco de espacio
						if (alumno != null || identificador != "FIN") {
							System.out.println(alumno.toString());
						} else if (identificador != "FIN"){
							System.out.println("El alumno con id " + identificador + " no existe.");
						}
						//Deja un poco de espacio entre el resultado y la siguiente ejecución
						System.out.println("\n");
					}
					break;
				case 3:
					System.out.println("Opción AñadirAlumno");
					Alumno alumnoAux = new Alumno();
					GregorianCalendar fechaAux = new GregorianCalendar();
					int year,month,day;
					System.out.print("Dime la ID del usuario a guardar: ");
					alumnoAux.setIdentificador(teclado.next().toUpperCase());
					/*Debido a que usamos la clase Scanner no podemos poner espacios a no ser
					 * que pidamos por teclado el Nombre y los apellidos y los juntemos todos
					 * en un String antes de enciarlos a la base de datos, pero para evitar
					 * pedir demasiados datos lo dejamos así, ya que es un problema que
					   al usar swing se solucionará	*/
					System.out.print("Dime el Nombre del usuario a guardar (Sin espacios): "); 
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
					AlumnosDAO.nuevoAlumno(alumnoAux);
					System.out.println("\n");
					break;
				case 4:
					System.out.println("Opción BorrarAlumno");
					System.out.print("Dime la ID del usuario a borrar");
					identificador = teclado.next().toUpperCase();
					if (identificador != null) {
						AlumnosDAO.borrarAlumno(identificador);
					}
					System.out.println("\n");
					break;
				case 5:
					System.out.println("Opción MostrarAlumnosIQ");
					System.out.println("Introduce el CI para obtener\nlos alumnos con un CI mayor");
					int ci = Integer.parseInt(teclado.next());
					ArrayList<Alumno> alumnosC5;
					try
					{
						alumnosC5 = AlumnosDAO.getAlumnoCi(ci);
						if (alumnosC5.size() != 0) {
							System.out.println(alumnosC5.size());
							for (int i = 0; i < alumnosC5.size(); i++) {
								System.out.println(alumnosC5.get(i).toString());
							}
						} else {
							System.out.println("No hay alumnos con tanto CI");
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
					System.out.println("\n");
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



