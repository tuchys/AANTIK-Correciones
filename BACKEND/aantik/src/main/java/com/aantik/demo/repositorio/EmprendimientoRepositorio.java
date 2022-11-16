package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Emprendimiento;


public interface EmprendimientoRepositorio extends CrudRepository<Emprendimiento,Long>{
	public Optional<Emprendimiento> findById(Long id);
	public Optional<Emprendimiento> getUserById(Long id) throws Exception;
	public Optional<Emprendimiento> findByNombreEmp(String nombreEmp);
	public Optional<Emprendimiento> findByLinAccion(String linAccion);
	public Emprendimiento getByCorreoIE(String correoIE);
}
