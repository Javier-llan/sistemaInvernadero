package com.sistema.invernadero.app.web.models.entities;

import java.io.Serializable;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="PLANTA")
public class Planta implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="IDPLANTA")
	private Integer idplanta;
	
	@Column(name="NOMBRE")
	@Size(max=50)
	@NotEmpty
	private String nombre;
	
	@Column(name="TIPO")
	@Size(max=50)
	@NotEmpty
	private String tipo;
	
	@Column(name="DESCRIPCION")
	@Size(max=150)
	@NotEmpty
	private String descripcion;
	
	@JoinColumn(name="IDCULTIVO",referencedColumnName="IDCULTIVO")
	@ManyToOne()
	private Cultivo cultivo;
	

	public Cultivo getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}

	public Planta() {
		super();
	}
	
	public Planta(Integer id) {
		super();
		this.idplanta=id;
	}

	public Integer getIdplanta() {
		return idplanta;
	}

	public void setIdplanta(Integer idplanta) {
		this.idplanta = idplanta;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
