package src;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alumno {
	private String identificador;
	private String nombre;
	private GregorianCalendar fechaNac;
	private double calificacion;
	private int ci;
	
	//Constructor convencional
	public Alumno(String identificador, String nombre, GregorianCalendar fechaNac, double calificacion, int ci) {
		this.setIdentificador(identificador);
		this.setNombre(nombre);
		this.setFechaNac(fechaNac);
		this.setCalificacion(calificacion);
		this.setCi(ci);
	}
	
	//Constructor por defecto
	public Alumno() {
		this("ID0", "Alumno" , new GregorianCalendar(), 0, 0);
	}
	
	//Constructor copia
	public Alumno(Alumno alumno) {
		this.identificador = alumno.identificador;
		this.nombre = alumno.nombre;
		this.fechaNac = alumno.fechaNac;
		this.calificacion = alumno.calificacion;
		this.ci = alumno.ci;
	}
	
	//Metodos
	public String toString() {
		return String.format("%-4s  %-30s  %s   %-4.1f  %d",
				this.getIdentificador(),
				this.getNombre(),
				this.getFechaNacString(),
				this.getCalificacion(),
				this.getCi());
	}
	
	//Setters and Getters
	public String getIdentificador() {
		return identificador;
	}
	public void setIdentificador(String identificador) {
		this.identificador = identificador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public GregorianCalendar getFechaNac() {
		return fechaNac;
	}
	//No modifico getFechaNac por si lo necesitamos para hacer operaciones sobre la fecha
	public String getFechaNacString() { 
		return String.format("%4s/%2s/%2s",
				this.getFechaNac().get(Calendar.YEAR),
				this.getFechaNac().get(Calendar.MONTH) + 1,
				this.getFechaNac().get(Calendar.DAY_OF_MONTH));
	}
	public void setFechaNac(GregorianCalendar fechaNac) {
		this.fechaNac = fechaNac;
	}
	public double getCalificacion() {
		return calificacion;
	}
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	
}//class
