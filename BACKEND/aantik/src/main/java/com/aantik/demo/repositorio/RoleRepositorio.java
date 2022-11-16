package com.aantik.demo.repositorio;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.repository.CrudRepository;
import com.aantik.demo.entidad.Role;

public interface RoleRepositorio extends CrudRepository<Role,Long>{
	public Optional<Role> findById(Long id);
	public Role getById(Long id) throws Exception;
	public Role findByName(String username);

}
