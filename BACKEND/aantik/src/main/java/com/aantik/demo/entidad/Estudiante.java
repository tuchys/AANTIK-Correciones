package com.aantik.demo.entidad;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Estudiante implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5136779542810096179L;
	/**
	 * 
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
    @Column(name = "id")
	private Long id;
	@Column
	private String nombre;
	@Column
	private String correo;
	@Column
	private String telefono;
	@Column
	private String direccion;		
	@Column
	private String asignatura;//CDIO-PSU
	@Column
	private String clase;
	@Column
	private String entidad;		
	@Column
	private String linAccion;			
	@Column
	private String idEstudiantil;		
	@Column
	private String identificacion;	
	@Column
	private String tallerSP; //taller sentido de mi practica	
	@Column
	private String fechaSP; //fecha asistencia sentido de mi practica			
	@Column
	private String infografia; //revision de infografia de pasos a seguir
	//personalizacion datos
	@Column
	public char genero;
	@Column
	public String documento;
	@Column
	public String ciudad;
	@Column
	public String localidad;
	@Column
	public String barrio;
	@Column
	public boolean actividadExtra;
	@Column
	public boolean experiencia;
	@Column
	public boolean limitacion;
	@Column
	public String limitLocalidad;
	@Column
	public boolean transporte;
	@Column
	public String docentePref;
	@Column
	public String docenteNoPref;   
	@Column
	public boolean promedio;
	@Column
	public String enfasis;
	@Column
	public String contacto;
	@Column
	public char modalidad;
	@Column
	public String disponibilidad;
	@Column
	public String notificaciones;
	@Column
	public String tipoOrg;
	@Column
	public String tipoEmp;
	@Column
	public String actividadEco;
	@Column
	public String comunidad;
	
	
	@JoinTable(name = "user",
	joinColumns=@JoinColumn(name="id"),
	inverseJoinColumns=@JoinColumn(name="id"))
	private long userId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public String getLinAccion() {
		return linAccion;
	}

	public void setLinAccion(String linAccion) {
		this.linAccion = linAccion;
	}

	public String getIdEstudiantil() {
		return idEstudiantil;
	}

	public void setIdEstudiantil(String idEstudiantil) {
		this.idEstudiantil = idEstudiantil;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getTallerSP() {
		return tallerSP;
	}

	public void setTallerSP(String tallerSP) {
		this.tallerSP = tallerSP;
	}

	public String getFechaSP() {
		return fechaSP;
	}

	public void setFechaSP(String fechaSP) {
		this.fechaSP = fechaSP;
	}

	public String getInfografia() {
		return infografia;
	}

	public void setInfografia(String infografia) {
		this.infografia = infografia;
	}

	public char getGenero() {
		return genero;
	}

	public void setGenero(char genero) {
		this.genero = genero;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
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

	public boolean isActividadExtra() {
		return actividadExtra;
	}

	public void setActividadExtra(boolean actividadExtra) {
		this.actividadExtra = actividadExtra;
	}

	public boolean isExperiencia() {
		return experiencia;
	}

	public void setExperiencia(boolean experiencia) {
		this.experiencia = experiencia;
	}

	public boolean isLimitacion() {
		return limitacion;
	}

	public void setLimitacion(boolean limitacion) {
		this.limitacion = limitacion;
	}

	public String getLimitLocalidad() {
		return limitLocalidad;
	}

	public void setLimitLocalidad(String limitLocalidad) {
		this.limitLocalidad = limitLocalidad;
	}

	public boolean isTransporte() {
		return transporte;
	}

	public void setTransporte(boolean transporte) {
		this.transporte = transporte;
	}

	public String getDocentePref() {
		return docentePref;
	}

	public void setDocentePref(String docentePref) {
		this.docentePref = docentePref;
	}

	public String getDocenteNoPref() {
		return docenteNoPref;
	}

	public void setDocenteNoPref(String docenteNoPref) {
		this.docenteNoPref = docenteNoPref;
	}

	public boolean isPromedio() {
		return promedio;
	}

	public void setPromedio(boolean promedio) {
		this.promedio = promedio;
	}

	public String getEnfasis() {
		return enfasis;
	}

	public void setEnfasis(String enfasis) {
		this.enfasis = enfasis;
	}

	public String getContacto() {
		return contacto;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
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

	public String getNotificaciones() {
		return notificaciones;
	}

	public void setNotificaciones(String notificaciones) {
		this.notificaciones = notificaciones;
	}

	public String getTipoOrg() {
		return tipoOrg;
	}

	public void setTipoOrg(String tipoOrg) {
		this.tipoOrg = tipoOrg;
	}

	public String getTipoEmp() {
		return tipoEmp;
	}

	public void setTipoEmp(String tipoEmp) {
		this.tipoEmp = tipoEmp;
	}

	public String getActividadEco() {
		return actividadEco;
	}

	public void setActividadEco(String actividadEco) {
		this.actividadEco = actividadEco;
	}

	public String getComunidad() {
		return comunidad;
	}

	public void setComunidad(String comunidad) {
		this.comunidad = comunidad;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, clase, correo, direccion, entidad, fechaSP, id, idEstudiantil, identificacion,
				infografia, linAccion, nombre, tallerSP, telefono, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estudiante other = (Estudiante) obj;
		return Objects.equals(asignatura, other.asignatura) && Objects.equals(clase, other.clase)
				&& Objects.equals(correo, other.correo) && Objects.equals(direccion, other.direccion)
				&& Objects.equals(entidad, other.entidad) && Objects.equals(fechaSP, other.fechaSP)
				&& Objects.equals(id, other.id) && Objects.equals(idEstudiantil, other.idEstudiantil)
				&& Objects.equals(identificacion, other.identificacion) && Objects.equals(infografia, other.infografia)
				&& Objects.equals(linAccion, other.linAccion) && Objects.equals(nombre, other.nombre)
				&& Objects.equals(tallerSP, other.tallerSP) && Objects.equals(telefono, other.telefono)
				&& userId == other.userId;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", asignatura=" + asignatura + ", clase=" + clase + ", entidad="
				+ entidad + ", linAccion=" + linAccion + ", idEstudiantil=" + idEstudiantil + ", identificacion="
				+ identificacion + ", tallerSP=" + tallerSP + ", fechaSP=" + fechaSP + ", infografia=" + infografia
				+ ", userId=" + userId + "]";
	}

	public boolean getPromedio() {
		// TODO Auto-generated method stub
		return this.promedio;
	}

	public boolean getTransporte() {
		// TODO Auto-generated method stub
		return this.transporte;
	}

	public boolean getLimitacion() {
		// TODO Auto-generated method stub
		return this.limitacion;
	}

	public boolean getExperiencia() {
		// TODO Auto-generated method stub
		return this.experiencia;
	}

	public boolean getActividadExtra() {
		// TODO Auto-generated method stub
		return this.actividadExtra;
	}	
	
}
