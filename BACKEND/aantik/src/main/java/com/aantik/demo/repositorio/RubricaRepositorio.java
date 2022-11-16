package com.aantik.demo.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.aantik.demo.entidad.Rubrica_preg_dg;

public interface RubricaRepositorio extends CrudRepository<Rubrica_preg_dg,Long> {
	public Optional<Rubrica_preg_dg> findById(Long id);
	public Optional<Rubrica_preg_dg> getUserById(Long id) throws Exception;
	public Iterable<Rubrica_preg_dg> findByIdPreg(Long idPreg);
}
