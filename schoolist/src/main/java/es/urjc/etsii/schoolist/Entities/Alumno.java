package es.urjc.etsii.schoolist.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Alumno {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String nombre, apellido1, apellido2;
	private String DNI;
	
	@ManyToOne
	private Grupo grupo;

	@ManyToOne
	private Parada parada;
	
	public Alumno() {
	}

	public Alumno( String nombre, String apellido1, String apellido2, String DNI) {
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.DNI = DNI;
	}
	public String getNombreCompleto() {
		return (nombre+ " "+ apellido1+" "+apellido2 +" ");
		
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Parada getParada() {
		return parada;
	}

	public void setParada(Parada parada) {
		this.parada = parada;
	}
		
}
