package es.urjc.etsii.schoolist.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Padre")
public class Padre extends Usuario{

	@OneToOne
	private Alumno hijo;

	public Padre() {
	}

	public Padre(Usuario user) {
		super(user.getId(), user.getNombre(), user.getApellido1(), user.getApellido2(), user.getPassWord());
	}
	
	public Padre(Alumno hijo) {
		super();
		this.hijo = hijo;
	}

	public Alumno getHijo() {
		return hijo;
	}

	public void setHijo(Alumno hijo) {
		this.hijo = hijo;
	}


}
