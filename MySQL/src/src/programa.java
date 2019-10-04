package src;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import dao.AlumnosDAO;

public class programa {


	public static void main(String[] args) throws SQLException {

		Scanner teclado = new Scanner(System.in);
		boolean finalizar = false;
		int opcion;

		while(!finalizar){

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

			case 1:
				ArrayList<Alumno> alumnos = AlumnosDAO.obtenerTodos();
				System.out.println("Opción MostrarDatos");
				System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
				System.out.println("===================================");
				for (int i = 0; i < alumnos.size(); i++) {
					System.out.printf("%s",
							alumnos.get(i).getNombre());
				}
				
				break;
			case 2:
				System.out.println("Opción Buscar Alumno");
				String identificador;
				identificador = teclado.next();
				//construimos la orden SELECT
				String sql= "SELECT * FROM alumnos WHERE identificador" + identificador + "ORDER BY 1";
				System.out.println(sql);
				break;
			case 3:
				System.out.println("Opción AñadirAlumno");
				Object nombre;
				Object fecha_de_nacimiento;
				Object calificacion;
				Object coeficiente_de_inteligencia;
				//construir orden INSERT	        
				/*sql = String.format("INSERT INTO alumnos VALUES (%s, '%s', '%s', '%s', '%s')",
						identificador,nombre, fecha_de_nacimiento, calificacion, coeficiente_de_inteligencia);*/

				//System.out.println(sql);
				break;
			case 4:
				System.out.println("Opción BorrarAlumno");
				identificador = teclado.next();
				
				if (identificador != null && identificador == "%(A-Za-z0-9)")
					query = "DELETE FROM alumnos WHERE identificador = ''";
				
				/*st.executeUpadte(query);
				System.out.println("el usuario fue eliminado");
				break;*/
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
				finalizar=true;
				break;
			default:
				
			}
		}
	}
}



