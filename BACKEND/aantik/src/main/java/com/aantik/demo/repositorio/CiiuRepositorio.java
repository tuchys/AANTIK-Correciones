package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.CIIU;


public interface CiiuRepositorio extends CrudRepository<CIIU,Long>{
	public Optional<CIIU> findById(Long id);
	public Optional<CIIU> getUserById(Long id) throws Exception;
	public Iterable<CIIU> findByActividad(String actividad);
	public Iterable<CIIU> findByAgrupacion(String Agrupacion);
	public Optional<CIIU> findByCodigo(String Codigo);
}
