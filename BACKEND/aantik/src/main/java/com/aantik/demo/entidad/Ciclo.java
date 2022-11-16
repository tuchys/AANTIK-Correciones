package com.aantik.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Ciclo{
	
	/**
	 * 
	 */
    @Id
    @GeneratedValue
    private long id;
	@Column
	private String periodo;
	@Column
	private boolean estado;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Ciclo(long id, String periodo, boolean estado) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.estado = estado;
	}
	
	public Ciclo() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}