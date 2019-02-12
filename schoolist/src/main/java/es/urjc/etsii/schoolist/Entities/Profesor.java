package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import java.util.Set;

@Entity
public class Profesor {

	@Id
	private String id;


	@ManyToMany
	private Set<Asignatura> asignaturas;

	public Profesor() {
	}

	public Profesor(String id, Set<Asignatura> asignaturas) {
		super();
		this.id = id;
		this.asignaturas = asignaturas;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}


}
