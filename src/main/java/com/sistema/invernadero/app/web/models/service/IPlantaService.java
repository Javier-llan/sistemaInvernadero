package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import com.sistema.invernadero.app.web.models.entities.Planta;

public interface IPlantaService {
	public void save(Planta planta);
	
	public Planta findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Planta>findAll();
}
