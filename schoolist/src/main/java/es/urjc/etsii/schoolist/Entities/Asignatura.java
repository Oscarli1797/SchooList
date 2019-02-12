package es.urjc.etsii.schoolist.Entities;

import java.util.Set;

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
	private Set<Grupo> grupo;
	
	public Asignatura() {
	}
	
	public Asignatura(String nombre, Set<Grupo> grupo) {
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

	public  Set<Grupo> getCurso() {
		return grupo;
	}

	public void setCurso( Set<Grupo> grupo) {
		this.grupo = grupo;
	}
	
}
