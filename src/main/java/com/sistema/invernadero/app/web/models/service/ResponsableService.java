package com.sistema.invernadero.app.web.models.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.sistema.invernadero.app.web.models.dao.IResponsable;
import com.sistema.invernadero.app.web.models.entities.Responsable;;

@Service
public class ResponsableService implements IResponsableService{

	@Autowired
	private IResponsable dao;
	
	@Override
	@Transactional
	public void save(Responsable responsable) {
		// TODO Auto-generated method stub
		dao.save(responsable);
	}

	@Override
	@Transactional(readOnly=true)
	public Responsable findById(Integer id) {
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
	public List<Responsable> findAll() {
		// TODO Auto-generated method stub
		return (List<Responsable>)dao.findAll();
	}

	
	
}
