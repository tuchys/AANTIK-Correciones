package com.aantik.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Foro{
	
	/**
	 * 
	 */
    @Id
    @GeneratedValue
    private long id;
	@Column(length = 2000)
	private String pregunta;
	@Column
	private String encargado;		
	@Column
	private String fecha;
	@Column
	private String correo;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getEncargado() {
		return encargado;
	}
	public void setEncargado(String encargado) {
		this.encargado = encargado;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public Foro(long id, String pregunta, String encargado, String fecha, String correo) {
		super();
		this.id = id;
		this.pregunta = pregunta;
		this.encargado = encargado;
		this.fecha = fecha;
		this.correo = correo;
	}
	public Foro() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}