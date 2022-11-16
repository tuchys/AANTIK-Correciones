package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Coordinador;


public interface CoordinadorRepositorio extends CrudRepository<Coordinador,Long>{
	public Optional<Coordinador> findById(Long id);
	public Optional<Coordinador> getUserById(Long id) throws Exception;
	public Optional<Coordinador> findByCorreo(String correo);
	public Optional<Coordinador> findByAsignatura(String asignatura);
	public Optional<Coordinador> findByNombre(String nombre);
}
