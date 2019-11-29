package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.invernadero.app.web.models.dao.ICuidado;
import com.sistema.invernadero.app.web.models.entities.Cuidado;

@Service
public class CuidadoService implements ICuidadoService{

	@Autowired
	private ICuidado dao;
	@Override
	@Transactional
	public void save(Cuidado cuidado) {
		// TODO Auto-generated method stub
		dao.save(cuidado);
	}

	@Override
	@Transactional(readOnly=true)
	public Cuidado findById(Integer id) {
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
	public List<Cuidado> findAll() {
		// TODO Auto-generated method stub
		return (List<Cuidado>)dao.findAll();
	}

}
