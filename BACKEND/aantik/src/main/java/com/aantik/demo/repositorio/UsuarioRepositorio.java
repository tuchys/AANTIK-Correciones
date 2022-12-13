package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.HelperClassServices.UserG;



public interface UsuarioRepositorio extends CrudRepository<UserG,Long>{
	public Optional<UserG> findById(Long id);
	public Optional<UserG> getUserById(Long id) throws Exception;
	public Optional<UserG> findByUsername(String username);
	public Iterable<UserG> getByRoles(long id);
	public UserG getById(long userId);
}
