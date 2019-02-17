package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mensaje {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String cabecera;
	private String texto;

	@OneToOne
	private User origen;
	
	@OneToOne
	private User destino;

	protected Mensaje() {
		// Used by SpringData
	}

	public Mensaje(User origen, User destino, String cabecera, String texto) {
		this.origen = origen;
		this.destino = destino;
		this.cabecera = cabecera;
		this.texto = texto;
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

	public void setOrigen(User origin_id) {
		this.origen = origin_id;
	}

	public void setDestino(User destination_id) {
		this.destino = destination_id;
	}

	public User getOrigen() {
		return origen;
	}

	public User getDestino() {
		return origen;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, origen, destino);
	}

}
