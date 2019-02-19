package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Set;

@Entity
public class Profesor {

	@Id
	private String id;
	
	@OneToOne
	//@MapsId
	private User usuario;

	@ManyToMany
	private Set<Asignatura> asignaturas;

	public Profesor() {
	}

	public Profesor(User user) {
		this.usuario = user;
		this.id = user.getNick();
	}

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public String getID() {
		return id;
	}

	public void setID(String id) {
		this.id = id;
	}


}
