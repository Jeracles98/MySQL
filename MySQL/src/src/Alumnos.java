package src;

import java.util.GregorianCalendar;

public class Alumnos {
	private String identificador;
	private String nombre;
	private GregorianCalendar fechaNac;
	private double calificacion;
	private int ci;
	
	//Constructor convencional
	public Alumnos(String identificador, String nombre, GregorianCalendar fechaNac, double calificacion, int ci) {
		this.setIdentificador(identificador);
		this.setNombre(nombre);
		this.setFechaNac(fechaNac);
		this.setCalificacion(calificacion);
		this.setCi(ci);
	}
	
	//Constructor por defecto
	public Alumnos() {
		this("ID0", "Alumno" , new GregorianCalendar(), 0, 0);
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
