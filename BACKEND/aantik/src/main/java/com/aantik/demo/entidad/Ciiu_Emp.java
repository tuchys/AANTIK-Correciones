package com.aantik.demo.entidad;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Ciiu_Emp {
	@Id
    @Column(name = "id")
	private String id;
	@Column
	private Long idCiiu;
	@Column
	private String idName;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getIdCiiu() {
		return idCiiu;
	}

	public void setIdCiiu(Long idCiiu) {
		this.idCiiu = idCiiu;
	}

	public String getIdName() {
		return idName;
	}

	public void setIdName(String idName) {
		this.idName = idName;
	}

	public Ciiu_Emp() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idCiiu, idName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ciiu_Emp other = (Ciiu_Emp) obj;
		return Objects.equals(id, other.id) && Objects.equals(idCiiu, other.idCiiu)
				&& Objects.equals(idName, other.idName);
	}

	@Override
	public String toString() {
		return "Ciiu_Emp [id=" + id + ", idCiiu=" + idCiiu + ", idName=" + idName + "]";
	}
	

}
