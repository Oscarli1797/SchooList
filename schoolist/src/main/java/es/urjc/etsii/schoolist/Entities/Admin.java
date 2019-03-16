package es.urjc.etsii.schoolist.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Admin")
public class Admin extends Usuario{
	
	public Admin() {
		
	}
	
	public Admin(Usuario user) {
		super(user.getId(), user.getNombre(), user.getApellido1(), user.getApellido2(), user.getPassWord(), user.getMail());
	}
	
}
