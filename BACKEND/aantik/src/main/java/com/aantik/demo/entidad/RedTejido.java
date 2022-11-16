package com.aantik.demo.entidad;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class RedTejido {
	
	@Id
    @Column(name = "id")
	private Long id;
	
    @Column
	private Long emprenOrigen;
	
    @Column
	private Long emprenDest;

	public Long getId() {
		return id;
	}

	public Long getEmprenOrigen() {
		return emprenOrigen;
	}

	public void setEmprenOrigen(Long emprenOrigen) {
		this.emprenOrigen = emprenOrigen;
	}

	public Long getEmprenDest() {
		return emprenDest;
	}

	public void setEmprenDest(Long emprenDest) {
		this.emprenDest = emprenDest;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "RedTejido [id=" + id + ", emprenOrigen=" + emprenOrigen + ", emprenDest=" + emprenDest + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((emprenDest == null) ? 0 : emprenDest.hashCode());
		result = prime * result + ((emprenOrigen == null) ? 0 : emprenOrigen.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RedTejido other = (RedTejido) obj;
		if (emprenDest == null) {
			if (other.emprenDest != null)
				return false;
		} else if (!emprenDest.equals(other.emprenDest))
			return false;
		if (emprenOrigen == null) {
			if (other.emprenOrigen != null)
				return false;
		} else if (!emprenOrigen.equals(other.emprenOrigen))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public RedTejido() {

	}


	
	
}
