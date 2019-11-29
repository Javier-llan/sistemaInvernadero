package com.sistema.invernadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.invernadero.app.web.models.entities.Cultivo;
public interface ICultivo extends CrudRepository<Cultivo, Integer>{

}
