package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.User;


public interface UsuarioRepositorio extends CrudRepository<User,Long>{
	public Optional<User> findById(Long id);
	public Optional<User> getUserById(Long id) throws Exception;
	public Optional<User> findByUsername(String username);
	public Iterable<User> getByRoles(long id);
}
