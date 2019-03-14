package es.urjc.etsii.schoolist.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Padre")
public class Padre extends Usuario{

	public Padre() {
	}

	public Padre(Usuario user) {
		super(user.getId(), user.getNombre(), user.getApellido1(), user.getApellido2(), user.getPassWord(), user.getMail());
	}
	

}
