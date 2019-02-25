package es.urjc.etsii.schoolist.Entities;

import javax.persistence.DiscriminatorValue;
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
@DiscriminatorValue("Profesor")
public class Profesor extends Usuario{

	public Profesor() {
		
	}
	
	public Profesor(Usuario user) {
		super(user.getId(), user.getNombre(), user.getApellido1(), user.getApellido2(), user.getPassWord());
	}
	
	@ManyToMany
	private Set<Asignatura> asignaturas;

	public Set<Asignatura> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(Set<Asignatura> asignaturas) {
		this.asignaturas = asignaturas;
	}



}
