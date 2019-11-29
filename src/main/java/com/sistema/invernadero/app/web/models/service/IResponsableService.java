package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import com.sistema.invernadero.app.web.models.entities.Responsable;

public interface IResponsableService {
	public void save(Responsable responsable);
	
	public Responsable findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Responsable>findAll();

}
