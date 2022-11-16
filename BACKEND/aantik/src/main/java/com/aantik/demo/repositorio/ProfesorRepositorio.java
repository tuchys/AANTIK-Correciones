package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Profesor;


public interface ProfesorRepositorio extends CrudRepository<Profesor,Long>{
	public Optional<Profesor> findById(Long id);
	public Optional<Profesor> getUserById(Long id) throws Exception;
	public Optional<Profesor> findByNombre(String nombre);
	public Profesor getById(long id);
}
