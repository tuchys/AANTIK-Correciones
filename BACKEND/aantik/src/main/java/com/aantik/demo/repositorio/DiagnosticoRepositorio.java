package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Diagnostico;


public interface DiagnosticoRepositorio extends CrudRepository<Diagnostico,Long>{
	public Optional<Diagnostico> findById(Long id);
	public Optional<Diagnostico> findByPreguntaCod(String codigo);
	public Iterable<Diagnostico> findByCorreo(String correo);
	public Diagnostico getByPreguntaCod(String preguntaCod);
}
