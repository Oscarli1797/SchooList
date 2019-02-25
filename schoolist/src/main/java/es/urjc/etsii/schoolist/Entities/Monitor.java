package es.urjc.etsii.schoolist.Entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
@DiscriminatorValue("Monitor")
public class Monitor extends Usuario{

	@OneToOne
	private Autobus bus;

	public Monitor() {
	}
	
	public Monitor(Usuario user) {
		super(user.getId(), user.getNombre(), user.getApellido1(), user.getApellido2(), user.getPassWord());
	}

	public Monitor(String id, Autobus bus) {
		super();
		this.bus = bus;
	}

	public Autobus getBus() {
		return bus;
	}

	public void setBus(Autobus bus) {
		this.bus = bus;
	}



}
