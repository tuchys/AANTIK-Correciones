package com.aantik.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Noticia{
	
	/**
	 * 
	 */
    @Id
    @GeneratedValue
    private long id;
	@Column(length = 500)
	private String titulo;
	@Column(length = 2000)
	private String noticiaa;
	@Column(length = 500)
	private String fuente;
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
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getNoticiaa() {
		return noticiaa;
	}
	public void setNoticiaa(String noticiaa) {
		this.noticiaa = noticiaa;
	}
	public String getFuente() {
		return fuente;
	}
	public void setFuente(String fuente) {
		this.fuente = fuente;
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
	public Noticia(long id, String titulo, String noticiaa, String fuente, String encargado, String fecha,
			String correo) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.noticiaa = noticiaa;
		this.fuente = fuente;
		this.encargado = encargado;
		this.fecha = fecha;
		this.correo = correo;
	}
	
	public Noticia() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	


	
}
