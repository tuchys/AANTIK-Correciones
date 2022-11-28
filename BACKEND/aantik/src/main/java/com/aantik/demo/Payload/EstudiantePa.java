package com.aantik.demo.Payload;

import javax.validation.constraints.*;

public class EstudiantePa {
    
    @NotBlank
    @Size(max = 50)
    @Email
    private String correo;
    private String documento;
    private String nombre;
    private String idEstudiantil;
    private String telefono;
    private String fechaSP;
    private String asignatura;

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getDocumento() {
        return documento;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getIdEstudiantil() {
        return idEstudiantil;
    }
    public void setIdEstudiantil(String idEstudiantil) {
        this.idEstudiantil = idEstudiantil;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getFechaSP() {
        return fechaSP;
    }
    public void setFechaSP(String fechaSP) {
        this.fechaSP = fechaSP;
    }
    public String getAsignatura() {
        return asignatura;
    }
    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }
    
    


}
