package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	

	private String cabecera;
	private String texto;
	
	private String origin_id;
	private String destination_id;
	
	protected Mensaje() {
		// Used by SpringData
	}

	public Mensaje(String origin_id, String destination_id) {
		this.origin_id = origin_id;
		this.destination_id = destination_id;
	}

	public String getCabecera() {
		return cabecera;
	}

	public void setCabecera(String cabecera) {
		this.cabecera = cabecera;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}



	public String getOrigin_id() {
		return origin_id;
	}

	public String getDestination_id() {
		return origin_id;
	}
	

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']",
				id, origin_id, destination_id);
	}
	
}
