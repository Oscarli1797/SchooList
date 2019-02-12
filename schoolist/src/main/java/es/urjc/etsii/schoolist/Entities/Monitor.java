package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Monitor {

	@Id
	private String id;

	@OneToOne
	private Autobus bus;

	public Monitor() {
	}

	public Monitor(String id, Autobus bus) {
		super();
		this.id = id;
		this.bus = bus;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Autobus getBus() {
		return bus;
	}

	public void setBus(Autobus bus) {
		this.bus = bus;
	}



}
