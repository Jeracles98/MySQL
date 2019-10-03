package src;

import java.sql.ResultSet;
import java.util.Scanner;

public class programa {


	public static void main(String[] args) {

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
			switch(opcion){
			
			case 1:
				System.out.println("Opción MostrarDatos");
				System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
		  		System.out.println("===================================");
		  		ResultSet columnas=null;
		  		columnas = dbmd.getColumns(null, "ejemplo", "departamentos", null);
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
				 //construimos la orden SELECT
				 String sql= "SELECT * FROM alumnos WHERE identificador" + identificador + "ORDER BY 1";
				break;
			case 3:
				System.out.println("Opción AñadirAlumno");
				break;
			case 4:
				System.out.println("Opción BorrarAlumno");
				break;
			case 5:
				System.out.println("Opción MostrarAlumnosIQ");
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

	

