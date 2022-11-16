package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.aantik.demo.entidad.Preguntas_Dig;

public interface PreguntaRepositorio extends CrudRepository<Preguntas_Dig,Long>{
	public Optional<Preguntas_Dig> findById(Long id);
	public Optional<Preguntas_Dig> getUserById(Long id) throws Exception;
	public Optional<Preguntas_Dig> findByCodigo(String cod);
	public Optional<Preguntas_Dig> findByPregunta(String pregunta);
	public Preguntas_Dig getByCodigo(String codigo);
	public Preguntas_Dig getByNumeroPregunta(int numero);
}
