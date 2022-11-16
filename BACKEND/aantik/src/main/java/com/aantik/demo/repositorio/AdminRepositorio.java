package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Admin;


public interface AdminRepositorio extends CrudRepository<Admin,Long>{
	public Optional<Admin> findById(Long id);
	public Optional<Admin> getUserById(Long id) throws Exception;
	public Optional<Admin> findByCorreo(String correo);
}
