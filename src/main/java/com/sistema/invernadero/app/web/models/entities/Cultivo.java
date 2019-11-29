package com.sistema.invernadero.app.web.models.entities;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="CULTIVO")
public class Cultivo implements Serializable {

	private static final long serialVersionUID=1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name="IDCULTIVO")
	private Integer idcultivo;
	
	@Column(name="NOMBRE")
	@Size(max=50)
	private String nombre;
	
	@Column(name="FECHAINICIO")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Calendar fechainicio;
	
	@Column(name="FECHAFIN")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Past
	private Calendar fechafin;
	
	@JoinColumn(name="IDBLOQUE",referencedColumnName="IDBLOQUE")
	@ManyToOne
	private Bloque bloque;
	
	public Bloque getBloque() {
		return bloque;
	}

	public void setBloque(Bloque bloque) {
		this.bloque = bloque;
	}

	@OneToMany(mappedBy="cultivo",fetch=FetchType.LAZY)
	private List<Planta>planta;
	
	
	public List<Planta> getPlanta() {
		return planta;
	}

	public void setPlanta(List<Planta> planta) {
		this.planta = planta;
	}

	@OneToMany(mappedBy="cultivo",fetch=FetchType.LAZY)
	private List<Cuidado>cuidado;
	

	public List<Cuidado> getCuidado() {
		return cuidado;
	}

	public void setCuidado(List<Cuidado> cuidado) {
		this.cuidado = cuidado;
	}

	public Cultivo() {
		super();
	}
	
	public Cultivo(Integer id) {
		super();
		this.idcultivo=id;
	}

	public Integer getIdcultivo() {
		return idcultivo;
	}

	public void setIdcultivo(Integer idcultivo) {
		this.idcultivo = idcultivo;
	}

	public Calendar getFechainicio() {
		return fechainicio;
	}

	public void setFechainicio(Calendar fechainicio) {
		this.fechainicio = fechainicio;
	}

	public Calendar getFechafin() {
		return fechafin;
	}

	public void setFechafin(Calendar fechafin) {
		this.fechafin = fechafin;
	}
	
}
