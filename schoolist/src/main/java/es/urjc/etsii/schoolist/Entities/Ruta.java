package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import antlr.collections.List;


@Entity
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private List paradas;
	
	public Ruta() {
	}

	public Ruta(List paradas) {
		super();
		this.paradas = paradas;
	}

	public List getParadas() {
		return paradas;
	}

	public void setParadas(List paradas) {
		this.paradas = paradas;
	}
	
	
	
}
