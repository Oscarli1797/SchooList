package es.urjc.etsii.schoolist.Entities;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import java.util.List;


@Entity
public class Ruta {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ElementCollection
	private List<String> paradas;
	
	public Ruta() {
	}

	public Ruta(List<String> paradas) {
		this.paradas = paradas;
	}

	public List<String> getParadas() {
		return paradas;
	}

	public void setParadas(List<String> paradas) {
		this.paradas = paradas;
	}
	
	
}
