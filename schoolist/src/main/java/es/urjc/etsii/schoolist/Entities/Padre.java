package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Padre {

	@Id
	private String id;

	@OneToOne
	private Alumno hijo;

	public Padre() {
	}

	public Padre(String id, Alumno hijo) {
		super();
		this.id = id;
		this.hijo = hijo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Alumno getHijo() {
		return hijo;
	}

	public void setHijo(Alumno hijo) {
		this.hijo = hijo;
	}


}
