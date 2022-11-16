package com.aantik.demo.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.aantik.demo.entidad.Ciclo;


public interface CicloRepositorio extends CrudRepository<Ciclo,String>{
	public Optional<Ciclo> findById(long id);
	public Ciclo getById(long id);


}
