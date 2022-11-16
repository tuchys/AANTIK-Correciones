package com.aantik.demo.entidad;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import org.hibernate.annotations.GenericGenerator;

@Entity
public class Emprendimiento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1126557132965499013L;
	/**
	 * 
	 */

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
    @Column(name = "id")
	private Long id;
	@Column
	private String nombreEmp;
	@Column
	private String direccion;
	@Column
	private String prodServ;
	@Column
	private String linAccion;
	//perfil usuario
	@Column
	private String NIT;
	@Column
	private String fechaCons;
	@Column
	private String orgSocial;
	@Column
	private String localidad;//****
	@Column
	private String barrio;
	@Column
	private String temaAsesorar;//**p
	@Column
	private String interlocutorEmp;
	@Column
	private String telefonoIE;
	@Column
	private String correoIE;
	@Column
	private String nombreInterOS;
	@Column
	private String telefonoIOS;
	@Column
	private String correoIOS;
	@Column
	private int cupos;//**p
	@Column
	private String empleados;
	@Column
	private String actividadEco;//**
	@Column
	private String contacto;//medio de comunicacion que prefiere**
	@Column
	private boolean experiencia;//**
	@Column
	private boolean promedio;//**
	@Column
	private String horarioNotif;
	@Column
	private char modalidad;//**
	@Column
	private String disponibilidad;
	@Column
	private String horarioAtencion;
	@Column
	private char genero;//**
	@Column
	private boolean limitacion;
	@Column
	private String comunidad;
	@Column
	private boolean transporte;//*p

	@JoinTable(name = "user",
			joinColumns=@JoinColumn(name="id"),
			inverseJoinColumns=@JoinColumn(name="userId"))
	private long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreEmp() {
		return nombreEmp;
	}

	public void setNombreEmp(String nombreEmp) {
		this.nombreEmp = nombreEmp;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getProdServ() {
		return prodServ;
	}

	public void setProdServ(String prodServ) {
		this.prodServ = prodServ;
	}

	public String getLinAccion() {
		return linAccion;
	}

	public void setLinAccion(String linAccion) {
		this.linAccion = linAccion;
	}

	public String getNIT() {
		return NIT;
	}

	public void setNIT(String nIT) {
		NIT = nIT;
	}

	public String getFechaCons() {
		return fechaCons;
	}

	public void setFechaCons(String fechaCons) {
		this.fechaCons = fechaCons;
	}

	public String getOrgSocial() {
		return orgSocial;
	}

	public void setOrgSocial(String orgSocial) {
		this.orgSocial = orgSocial;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getTemaAsesorar() {
		return temaAsesorar;
	}

	public void setTemaAsesorar(String temaAsesorar) {
		this.temaAsesorar = temaAsesorar;
	}

	public String getInterlocutorEmp() {
		return interlocutorEmp;
	}

	public void setInterlocutorEmp(String interlocutorEmp) {
		this.interlocutorEmp = interlocutorEmp;
	}

	public String getTelefonoIE() {
		return telefonoIE;
	}

	public void setTelefonoIE(String telefonoIE) {
		this.telefonoIE = telefonoIE;
	}

	public String getCorreoIE() {
		return correoIE;
	}

	public void setCorreoIE(String correoIE) {
		this.correoIE = correoIE;
	}

	public String getNombreInterOS() {
		return nombreInterOS;
	}

	public void setNombreInterOS(String nombreInterOS) {
		this.nombreInterOS = nombreInterOS;
	}

	public String getTelefonoIOS() {
		return telefonoIOS;
	}

	public void setTelefonoIOS(String telefonoIOS) {
		this.telefonoIOS = telefonoIOS;
	}

	public String getCorreoIOS() {
		return correoIOS;
	}

	public void setCorreoIOS(String correoIOS) {
		this.correoIOS = correoIOS;
	}

	public int getCupos() {
		return cupos;
	}

	public void setCupos(int cupos) {
		this.cupos = cupos;
	}

	public String getEmpleados() {
		return empleados;
	}

	public void setEmpleados(String empleados) {
		this.empleados = empleados;
	}

	public String getActividadEco() {
		return actividadEco;
	}

	public void setActividadEco(String actividadEco) {
		this.actividadEco = actividadEco;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public boolean isExperiencia() {
		return experiencia;
	}

	public void setExperiencia(boolean experiencia) {
		this.experiencia = experiencia;
	}

	public boolean isPromedio() {
		return promedio;
	}

	public void setPromedio(boolean promedio) {
		this.promedio = promedio;
	}

	public String getHorarioNotif() {
		return horarioNotif;
	}

	public void setHorarioNotif(String horarioNotif) {
		this.horarioNotif = horarioNotif;
	}

	public char getModalidad() {
		return modalidad;
	}

	public void setModalidad(char modalidad) {
		this.modalidad = modalidad;
	}

	public String getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}

	public String getHorarioAtencion() {
		return horarioAtencion;
	}

	public void setHorarioAtencion(String horarioAtencion) {
		this.horarioAtencion = horarioAtencion;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public boolean isLimitacion() {
		return limitacion;
	}

	public void setLimitacion(boolean limitacion) {
		this.limitacion = limitacion;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public boolean isTransporte() {
		return transporte;
	}

	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public boolean getExperiencia() {
		// TODO Auto-generated method stub
		return this.experiencia;
	}

	public boolean getLimitacion() {
		// TODO Auto-generated method stub
		return this.limitacion;
	}

	public boolean getPromedio() {
		// TODO Auto-generated method stub
		return this.promedio;
	}

	public boolean getTransporte() {
		// TODO Auto-generated method stub
		return this.transporte;
	}

	
	
}
