package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import antlr.collections.List;


@Entity
public class Grupo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private List alumnos;

	public Grupo() {
	}
	
	public Grupo(List alumnos) {
		super();
		this.alumnos = alumnos;
	}

	public List getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(List alumnos) {
		this.alumnos = alumnos;
	}
	
	
	
}
