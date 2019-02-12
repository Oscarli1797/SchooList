package es.urjc.etsii.schoolist.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Falta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private Date fecha;
	
	@ManyToOne
	private Padre padre;

	public Falta() {

	}

	public Falta(long id, Date fecha, Padre padre) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.padre = padre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Padre getAlumno() {
		return padre;
	}

	public void setAlumno(Padre padre) {
		this.padre = padre;
	}
	
	
}
