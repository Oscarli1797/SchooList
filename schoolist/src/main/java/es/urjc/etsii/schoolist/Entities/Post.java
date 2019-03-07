package es.urjc.etsii.schoolist.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo,texto;
	
	private Date fecha;

	@OneToOne
	private Admin creador;
	
	public Post(){
	}

	
	public Post(String titulo, String texto, Admin creador) {
		super();
		this.titulo = titulo;
		this.texto = texto;
		this.creador = creador;
	}

	
	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Admin getCreador() {
		return creador;
	}

	public void setCreador(Admin creador) {
		this.creador = creador;
	}

}

