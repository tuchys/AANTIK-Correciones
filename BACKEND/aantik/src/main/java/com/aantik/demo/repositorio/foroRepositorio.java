package com.aantik.demo.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import com.aantik.demo.entidad.Foro;


public interface foroRepositorio extends CrudRepository<Foro,String>{
	public Optional<Foro> findById(long id);
	public Optional<Foro> getUserById(long id) throws Exception;

}
