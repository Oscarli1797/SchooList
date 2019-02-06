package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
public class Autobus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Monitor monitor;
	
	@OneToMany
	private List<Alumno> alumnos;
	
	
	private Ruta ruta;
	
	public Autobus() {
	}
	public Autobus(Monitor monitor, List alumnos, Ruta ruta) {
		super();
		this.monitor = monitor;
		this.alumnos = alumnos;
		this.ruta = ruta;
	}
	public Monitor getMonitor() {
		return monitor;
	}
	public void setMonitor(Monitor monitor) {
		this.monitor = monitor;
	}
	public List getNinos() {
		return alumnos;
	}
	public void setNinos(List ninos) {
		this.alumnos = ninos;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	
	
}
