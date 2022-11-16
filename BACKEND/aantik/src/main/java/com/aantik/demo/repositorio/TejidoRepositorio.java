package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.RedTejido;
import com.aantik.demo.entidad.CIIU;

public interface TejidoRepositorio extends CrudRepository<RedTejido,Long>{
	public Optional<RedTejido> findById(Long id);
	public Optional<RedTejido> getUserById(Long id) throws Exception;
	public Optional<RedTejido> findByemprenOrigen(CIIU username);
	public Optional<RedTejido> findByemprenDest(CIIU emprenDest);
}
