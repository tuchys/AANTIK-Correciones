package com.aantik.demo.entidad;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import javax.persistence.OneToMany;

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
