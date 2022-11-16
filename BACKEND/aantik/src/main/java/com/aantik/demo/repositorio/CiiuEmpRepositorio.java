package com.aantik.demo.repositorio;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.aantik.demo.entidad.Ciiu_Emp;
public interface CiiuEmpRepositorio  extends CrudRepository<Ciiu_Emp,String>{
	public Optional<Ciiu_Emp> findById(String id);
	public Optional<Ciiu_Emp> getUserById(String id) throws Exception;
	public Optional<Ciiu_Emp> findByIdName(String nombre);
}
