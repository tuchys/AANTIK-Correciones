package com.aantik.demo.entidad;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "DefinicionBenchIndicadores")
public class PreguntasModeloB {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Column(name = "IndicadoresId")
  private String indicaid;

  @Column(name = "Descripcion")
  private String descripcion;

public long getId() {
    return id;
}

public void setId(long id) {
    this.id = id;
}

public String getIndicaid() {
    return indicaid;
}

public void setIndicaid(String indicaid) {
    indicaid = indicaid;
}

public String getdescripcion() {
    return descripcion;
}

public void setdescripcion(String descripcion) {
    this.descripcion = descripcion;
}

public PreguntasModeloB(String indicaid, String descripcion) {
    this.indicaid = indicaid;
    this.descripcion = descripcion;
}

public PreguntasModeloB() {
}


}
