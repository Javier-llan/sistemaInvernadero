package com.sistema.invernadero.app.web.models.service;

import java.util.List;


import com.sistema.invernadero.app.web.models.entities.Cuidado;

public interface ICuidadoService {
	

    public void save(Cuidado cuidado);
	
	public Cuidado findById(Integer id);
	
	public void delete(Integer id);
	
	public List<Cuidado>findAll();
}
