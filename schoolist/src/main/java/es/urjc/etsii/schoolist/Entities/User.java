package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class User {

	@Id
	private String nick;
	
	private String nombre, apellido1, apellido2,passWord, rol;
	
	public User() {
		
	}

	public User(String nick, String nombre, String apellido1, String apellido2, String passWord) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.passWord = passWord;
	}
	
	public String getRol() {
		return rol;
		
	}public void setRol(String rol) {
		this.rol = rol;
	}
	
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}


}
