package com.sistema.invernadero.app.web.models.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="RESPONSABLE")
public class Responsable implements Serializable{
	
	private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="IDRESPONSABLE")
	private Integer idresponsable;
	
	@Column(name="NOMBRE")
	@Size(max=50)
	@NotEmpty
	private String nombre;
	
	@Column(name="APELLIDO")
	@Size(max=50)
	@NotEmpty
	private String apellido;
	
	@Column(name="TELEFONO")
	@Size(max=10)
	@NotEmpty
	private String telefono;
	
	@Column(name="EMAIL")
	@Size(max=50)
	@NotEmpty
	private String email;
	
	@OneToMany(mappedBy="responsable",fetch=FetchType.LAZY)
	private List<Cuidado>cuidado;
	
	public List<Cuidado> getCuidado() {
		return cuidado;
	}

	public void setCuidado(List<Cuidado> cuidado) {
		this.cuidado = cuidado;
	}

	public Responsable() {
		super();
	}
	
	public Responsable(Integer id) {
		super();
		this.idresponsable=id;
	}

	public Integer getIdresponsable() {
		return idresponsable;
	}

	public void setIdresponsable(Integer idresponsable) {
		this.idresponsable = idresponsable;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
