package com.aantik.demo.entidad;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;


@Entity
@Table(	name = "asignacion")

public class Asignacion {
	
    @Id
    @GeneratedValue
    private long id1;
    
    private long id;
    private String nombre;
    private String correo;   
    private String emprendimiento;
    private String fecha; 
	

	public long getId1() {
		return id1;
	}

	public void setId1(long id1) {
		this.id1 = id1;
	}
    public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEmprendimiento() {
		return emprendimiento;
	}

	public void setEmprendimiento(String emprendimiento) {
		this.emprendimiento = emprendimiento;
	}


	public Asignacion(long id, String nombre, @Email String correo, String emprendimiento, String fecha) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.emprendimiento = emprendimiento;
		this.fecha = fecha;


	}


	public Asignacion() {

	}


}
