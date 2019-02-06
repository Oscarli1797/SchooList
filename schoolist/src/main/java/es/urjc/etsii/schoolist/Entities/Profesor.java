package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;


@Entity
public class Profesor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre, apellido1, apellido2;
	
	@OneToMany
	private List<Asignatura> asignaturas;

	public Profesor() {
	}
	
	public Profesor(String nombre, String apellido1, String apellido2, List asignaturas) {
		super();
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.asignaturas = asignaturas;
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

	public List getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(List asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
	
}
