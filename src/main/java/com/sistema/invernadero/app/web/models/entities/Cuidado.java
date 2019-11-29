package com.sistema.invernadero.app.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name="CUIDADO")
public class Cuidado implements Serializable{
	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Basic(optional=false)
	@Column(name="IDCUIDADO")
	private Integer idcuidado;
	
	@Column(name="NOMBRE")
	@Size(max=50)
	private String nombre;
	
	@Column(name="FECHAREALIZACION")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Calendar fecharealizacion;
	
	@Column(name="DESCRIPCION")
	@Size(max=150)
	private String descripcion;
	
	@JoinColumn(name="IDRESPONSABLE",referencedColumnName="IDRESPONSABLE")
	@ManyToOne
	private Responsable responsable;
	
	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}

	@JoinColumn(name="IDCULTIVO",referencedColumnName="IDCULTIVO")
	@ManyToOne()
	private Cultivo cultivo;
	

	public Cultivo getCultivo() {
		return cultivo;
	}

	public void setCultivo(Cultivo cultivo) {
		this.cultivo = cultivo;
	}

	public Cuidado() {
		super();
	}
	
	public Cuidado(Integer id) {
		super();
		this.idcuidado=id;
	}

	public Integer getIdcuidado() {
		return idcuidado;
	}

	public void setIdcuidado(Integer idcuidado) {
		this.idcuidado = idcuidado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Calendar getFecharealizacion() {
		return fecharealizacion;
	}

	public void setFecharealizacion(Calendar fecharealizacion) {
		this.fecharealizacion = fecharealizacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
