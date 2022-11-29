package com.aantik.demo.repositorio;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import com.aantik.demo.entidad.OrgSocial;


public interface OrgSocialRepositorio extends CrudRepository<OrgSocial,Long>{
	public Optional<OrgSocial> findById(Long id);
	public Optional<OrgSocial> getUserById(Long id) throws Exception;
	public OrgSocial getByCorreoIOS(String correoIOS);
	public Optional<OrgSocial> findByNombreEmp(String nombreEmp);
	public OrgSocial getById(long id);

}
