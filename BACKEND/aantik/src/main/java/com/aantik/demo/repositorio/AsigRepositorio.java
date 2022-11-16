package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Asignacion;



public interface AsigRepositorio extends CrudRepository<Asignacion,Long>{
	public Optional<Asignacion> findById(Long id);
	public Optional<Asignacion> getUserById(Long id) throws Exception;
	public Optional<Asignacion> getUserById1(Long id1) throws Exception;
	}
