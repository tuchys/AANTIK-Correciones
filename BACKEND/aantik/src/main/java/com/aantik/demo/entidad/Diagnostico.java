package com.aantik.demo.entidad;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Diagnostico implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6368266777122525854L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long id;

	@JoinTable(name = "Preguntas_Dig",
	joinColumns=@JoinColumn(name="codigo"),
	inverseJoinColumns=@JoinColumn(name="preguntaCod"))
	private String preguntaCod;
	@Column
	private String puntajeS;
	@Column
	private int puntajeN;
	@Column
	private String correo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getPreguntaCod() {
		return preguntaCod;
	}
	public void setPreguntaCod(String preguntaCod) {
		this.preguntaCod = preguntaCod;
	}
	public String getPuntajeS() {
		return puntajeS;
	}
	public void setPuntajeS(String puntajeS) {
		this.puntajeS = puntajeS;
	}
	public int getPuntajeN() {
		return puntajeN;
	}
	public void setPuntajeN(int puntajeN) {
		this.puntajeN = puntajeN;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	
}
