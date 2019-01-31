package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	private String id;
	
	private String password;
	
	private int tipo_user;
	
	public User() {
		
	}

	public User(String password, int tipo_user) {
		super();
		this.password = password;
		this.tipo_user = tipo_user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getTipo_user() {
		return tipo_user;
	}

	public void setTipo_user(int tipo_user) {
		this.tipo_user = tipo_user;
	}
	
}
