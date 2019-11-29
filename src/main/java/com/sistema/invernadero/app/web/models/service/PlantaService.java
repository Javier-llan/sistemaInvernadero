package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.invernadero.app.web.models.dao.IPlanta;
import com.sistema.invernadero.app.web.models.entities.Planta;

@Service
public class PlantaService implements IPlantaService{

	@Autowired
	private IPlanta dao;
	@Override
	@Transactional
	public void save(Planta planta) {
		// TODO Auto-generated method stub
		dao.save(planta);
	}

	@Override
	@Transactional(readOnly=true)
	public Planta findById(Integer id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Planta> findAll() {
		// TODO Auto-generated method stub
		return (List<Planta>)dao.findAll();
	}

}
