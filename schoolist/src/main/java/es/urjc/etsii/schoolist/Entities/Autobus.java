package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import antlr.collections.List;


@Entity
public class Autobus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Monitor monitor;
	private List ninos;
	private Ruta ruta;
	
	public Autobus() {
	}
	public Autobus(Monitor monitor, List ninos, Ruta ruta) {
		super();
		this.monitor = monitor;
		this.ninos = ninos;
		this.ruta = ruta;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	public List getNinos() {
		return ninos;
	}
	public void setNinos(List ninos) {
		this.ninos = ninos;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	
}
