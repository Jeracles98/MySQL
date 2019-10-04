package src;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JOptionPane;

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
				System.out.println("Opción MostrarDatos");
				System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
				System.out.println("===================================");
				ResultSet columnas=null;
				Object dbmd;
				//columnas = dbmd.getColumns(null, "ejemplo", "departamentos", null);
				while (columnas.next()) {			   
					String nombCol = columnas.getString("COLUMN_NAME"); 
					String tipoCol = columnas.getString("TYPE_NAME");   
					String tamCol = columnas.getString("COLUMN_SIZE");  
					String nula  = columnas.getString("IS_NULLABLE");   

					System.out.printf("Columna: %s, Tipo: %s, Tamaño: %s, ¿Puede ser Nula:? %s %n", nombCol, tipoCol, tamCol, nula);
				}
				break;
			case 2:
				System.out.println("Opción BuscarAlumno");
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
				System.out.println("Opción ");
			}
		}
	}
}



