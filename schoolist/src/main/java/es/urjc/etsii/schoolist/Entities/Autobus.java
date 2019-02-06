package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import java.util.Set;

@Entity
public class Autobus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToOne
	private Monitor monitor;

	@OneToMany
	private Set<Alumno> alumnos;

	@OneToOne
	private Ruta ruta;

	public Autobus() {
	}

	public Autobus(Monitor monitor, Set<Alumno> alumnos, Ruta ruta) {
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

	public Set<Alumno> getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Set<Alumno> ninos) {
		this.alumnos = ninos;
	}

	public Ruta getRuta() {
		return ruta;
	}

	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}

}
