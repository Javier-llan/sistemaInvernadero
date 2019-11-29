package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import com.sistema.invernadero.app.web.models.entities.Bloque;

public interface IBloqueService {
	
    public void save(Bloque bloque);
	
	public Bloque findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Bloque>findAll();

}
