package com.sistema.invernadero.app.web.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.sistema.invernadero.app.web.models.entities.Cuidado;
public interface ICuidado extends CrudRepository<Cuidado,Integer>{

}
