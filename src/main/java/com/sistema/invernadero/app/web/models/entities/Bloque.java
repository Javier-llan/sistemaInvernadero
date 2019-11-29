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
import javax.validation.constraints.Size;



@Entity
@Table(name="BLOQUE")
public class Bloque implements Serializable{

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="IDBLOQUE")
	private Integer idbloque;
	
	@Column(name="NOMBRE")
	@Size(max=20)
	private String nombre;
	
	@Column(name="LOCACION")
	@Size(max=50)
	private String locacion;
	
	@Column(name="AREA")
	private Float area;
	
	@Column(name="NUMERO_SURCOS")
	private Integer numero_surcos;
	
	@OneToMany(mappedBy="bloque",fetch= FetchType.LAZY)
	private List<Cultivo>cultivo;
	

	public List<Cultivo> getCultivo() {
		return cultivo;
	}

	public void setCultivo(List<Cultivo> cultivo) {
		this.cultivo = cultivo;
	}

	public Bloque() {
		super();
	}
	
	public Bloque(Integer id) {
		super();
		this.idbloque=id;
	}

	public Integer getIdbloque() {
		return idbloque;
	}

	public void setIdbloque(Integer idbloque) {
		this.idbloque = idbloque;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLocacion() {
		return locacion;
	}

	public void setLocacion(String locacion) {
		this.locacion = locacion;
	}

	public Float getArea() {
		return area;
	}

	public void setArea(Float area) {
		this.area = area;
	}

	public Integer getNumero_surcos() {
		return numero_surcos;
	}

	public void setNumero_surcos(Integer numero_surcos) {
		this.numero_surcos = numero_surcos;
	}
	
	
}
