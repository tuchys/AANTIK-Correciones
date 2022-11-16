package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Estudiante;


public interface EstudianteRepositorio extends CrudRepository<Estudiante,Long>{
	public Optional<Estudiante> findById(Long id);
	public Optional<Estudiante> getUserById(Long id) throws Exception;
	public Optional<Estudiante> findByIdEstudiantil(Long idEstudiantil);
	public Optional<Estudiante> findByIdentificacion(Long identificacion);
	public Optional<Estudiante> findByNombre(String nombre);
	public Estudiante getByCorreo(String correo);
	public Optional<Estudiante> findByUserId(Long id);
	public Estudiante getByUserId(Long id);
}
