package com.aantik.demo.entidad;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.aantik.demo.entidad.PreguntasModeloB;

@Entity
@Table(name = "BenchIndicadores")
public class BenchmarkingIndica {
    
@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    public long idBenchIndica;

    public String categoriaPregunta;
   
    public String idPregunta;

    public Integer idDef;
    
    public long getIdBenchIndica() {
        return idBenchIndica;
    }
    public void setIdBenchIndica(long idBenchIndica) {
        this.idBenchIndica = idBenchIndica;
    }
   /*  public String getIdPregunta() {
        return idPregunta;
    }
    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }*/
    public String getCategoriaPregunta() {
        return categoriaPregunta;
    }
    public void setCategoriaPregunta(String categoriaPregunta) {
        this.categoriaPregunta = categoriaPregunta;
    }
   
    public BenchmarkingIndica(String idPregunta, String categoriaPregunta,Integer idDef) {
        this.idPregunta = idPregunta;
        this.categoriaPregunta = categoriaPregunta;
        this.idDef = idDef;
    }
    public BenchmarkingIndica() {
    }
    public String getIdPregunta() {
        return idPregunta;
    }
    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
        name="BenchIndicadores_DefinicionBenchIndicadores",
        joinColumns = @JoinColumn(name= "Indicador_id"),
        inverseJoinColumns = @JoinColumn(name="Defini_id"))
    private Set<PreguntasModeloB> preguntasModeloB = new HashSet<>();

    public Set<PreguntasModeloB> getPreguntasModeloB() {
        return preguntasModeloB;
    }
    public void setPreguntasModeloB(Set<PreguntasModeloB> preguntasModeloB) {
        this.preguntasModeloB = preguntasModeloB;
    }
    public Integer getIdDef() {
        return idDef;
    }
    public void setIdDef(Integer idDef) {
        this.idDef = idDef;
    }

    

}
