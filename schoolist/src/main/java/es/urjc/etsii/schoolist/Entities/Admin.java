package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Admin {

	@Id
	private String id;
	
	@OneToOne
	//@MapsId
	private User usuario;


	public Admin() {
	}
	
	public Admin(User user) {
		this.usuario = user;
		this.usuario.setRol("admin");
		this.id = user.getNick();
	}
	

	public Admin(String id) {
		super();
		this.usuario.setRol("admin");
		this.id = id;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


}
