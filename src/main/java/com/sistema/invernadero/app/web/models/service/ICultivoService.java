package com.sistema.invernadero.app.web.models.service;

import java.util.List;


import com.sistema.invernadero.app.web.models.entities.Cultivo;

public interface ICultivoService {

	 	public void save(Cultivo cultivo);
		
		public Cultivo findById(Integer id);
		
		public void delete(Integer id);
		
		public List<Cultivo>findAll();
}
