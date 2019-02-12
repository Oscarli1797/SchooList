package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Asignatura {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	
	@ManyToMany
	private Grupo grupo;
	
	public Asignatura() {
	}
	
	public Asignatura(String nombre, Grupo grupo) {
		super();
		this.nombre = nombre;
		this.grupo = grupo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Grupo getCurso() {
		return grupo;
	}

	public void setCurso(Grupo grupo) {
		this.grupo = grupo;
	}
	
}
