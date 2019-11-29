package com.sistema.invernadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.invernadero.app.web.models.entities.Planta;

public interface IPlanta extends CrudRepository<Planta, Integer>{

}
