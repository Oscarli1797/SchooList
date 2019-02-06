package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	private String nombre, apellido1, apellido2;
	private String DNI;
	
	@OneToOne
	private Autobus bus;
	
	@OneToOne
	private Curso curso;
	
	@OneToOne
	private Grupo grupo;
	// Paradas
	
	public Alumno() {
	}
	
	public Alumno(String nombre, String apellido1, String apellido2, String dNI, Autobus bus, Curso curso,
			Grupo grupo) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		DNI = dNI;
		this.bus = bus;
		this.curso = curso;
		this.grupo = grupo;
	}
	
	public String getNombre() {
		return nombre;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
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

	public Autobus getBus() {
		return bus;
	}

	public void setBus(Autobus bus) {
		this.bus = bus;
	}
	
}
