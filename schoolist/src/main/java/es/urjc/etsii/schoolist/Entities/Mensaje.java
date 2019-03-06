package es.urjc.etsii.schoolist.Entities;

import java.sql.Date;

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

	private String asunto;
	private String texto;

	private Date fecha;
	
	@OneToOne
	private Usuario origen;

	@OneToOne
	private Usuario destino;

	protected Mensaje() {
		// Used by SpringData
	}

	public Mensaje(Usuario origen, Usuario destino, String asunto, String texto) {
		this.origen = origen;
		this.destino = destino;
		this.asunto = asunto;
		this.texto = texto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getAsunto() {
		return asunto;
	}

	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setOrigen(Usuario origin_id) {
		this.origen = origin_id;
	}

	public void setDestino(Usuario destination_id) {
		this.destino = destination_id;
	}

	public Usuario getOrigen() {
		return origen;
	}

	public Usuario getDestino() {
		return origen;
	}

	@Override
	public String toString() {
		return String.format("Customer[id=%d, firstName='%s', lastName='%s']", id, origen, destino);
	}

}
