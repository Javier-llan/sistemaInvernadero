package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.sistema.invernadero.app.web.models.dao.IBloque;
import com.sistema.invernadero.app.web.models.entities.Bloque;

@Service
public class BloqueService implements IBloqueService{

	@Autowired
	private IBloque dao;
	@Override
	@Transactional
	public void save(Bloque bloque) {
		// TODO Auto-generated method stub
		dao.save(bloque);
	}

	@Override
	@Transactional(readOnly=true)
	public Bloque findById(Integer id) {
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
	public List<Bloque> findAll() {
		// TODO Auto-generated method stub
		return (List<Bloque>)dao.findAll();
	}

}
