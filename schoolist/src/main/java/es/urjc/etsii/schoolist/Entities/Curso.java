package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import antlr.collections.List;


@Entity
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombre;
	private List asignaturas;

	public Curso() {
	}
	
	public Curso(String nombre, List asignaturas) {
		super();
		this.nombre = nombre;
		this.asignaturas = asignaturas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List getAsignaturas() {
		return asignaturas;
	}
	public void setAsignaturas(List asignaturas) {
		this.asignaturas = asignaturas;
	}
	
	
}
