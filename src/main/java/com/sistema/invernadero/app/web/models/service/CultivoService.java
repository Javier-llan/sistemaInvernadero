package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.invernadero.app.web.models.dao.ICultivo;
import com.sistema.invernadero.app.web.models.entities.Cultivo;

@Service
public class CultivoService implements ICultivoService{

	@Autowired
	private ICultivo dao;
	@Override
	@Transactional
	public void save(Cultivo cultivo) {
		// TODO Auto-generated method stub
		dao.save(cultivo);
	}

	@Override
	@Transactional(readOnly=true)
	public Cultivo findById(Integer id) {
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
	public List<Cultivo> findAll() {
		// TODO Auto-generated method stub
		return (List<Cultivo>)dao.findAll();
	}

}
