package com.aantik.demo.service;

import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aantik.demo.entidad.Noticia;
import com.aantik.demo.entidad.OrgSocial;
import com.aantik.demo.entidad.Role;
import com.aantik.demo.entidad.User;
import com.aantik.demo.model.ModOrgSocial;
import com.aantik.demo.repositorio.OrgSocialRepositorio;
import com.aantik.demo.repositorio.RoleRepositorio;
import com.aantik.demo.repositorio.UsuarioRepositorio;

@Service
public class OrgSocialCRUD implements OrgSocialCRUDLocal{

	@Autowired
	OrgSocialRepositorio repository;
	@Autowired
	UsuarioRepositorio repositoryUser;
	@Autowired
	RoleRepositorio repositoryRol;
	
	private boolean checkOrgSocialExiste(OrgSocial org) throws Exception {
		Optional<OrgSocial> orgEncontrado = repository.findById(org.getId());
		if(orgEncontrado.isPresent()) {
			throw new Exception("Usuario ya se encuentra registrado");
		}
		return true;
	}
	
	@Override
	public OrgSocial crearOrganizacion(OrgSocial org) throws Exception {
		if(checkOrgSocialExiste(org)) {
			org = repository.save(org);
		}
		return org;
	}

	@Override
	public Iterable<OrgSocial> getAll() {
        return repository.findAll();
	}

	public void saveAll(ModOrgSocial[] orgLista) {
		// TODO Auto-generated method stub
		OrgSocial orgS=new OrgSocial();
		System.out.println("VERIFICANDO "+orgLista.length);
		for(int i =0;i<orgLista.length;i++) {
			orgS=new OrgSocial();
			if(orgLista[i]!=null) {
				orgS.setActividadEco (orgLista[i].actividadEco) ;                                                   
				orgS.setBarrio (orgLista[i].barrio) ;                                                         
				orgS.setComunidad (orgLista[i].comunidad) ;                                                      
				orgS.setContacto (orgLista[i].contacto) ;                                                       
				orgS.setCorreoIOS (orgLista[i].correoIOS) ;                                                      
				orgS.setCupos (orgLista[i].cupos) ;                                                          
				orgS.setDireccion (orgLista[i].direccion) ;                                                      
				orgS.setDisponibilidad (orgLista[i].disponibilidad) ;                                                 
				orgS.setEmpleados (orgLista[i].empleados) ;                                                      
				orgS.setExperiencia (orgLista[i].experiencia) ;                                                    
				orgS.setFechaCons (orgLista[i].fechaCons) ;                                                      
				orgS.setGenero (orgLista[i].genero) ;                                                         
				orgS.setHorarioAtencion (orgLista[i].horarioAtencion) ;                                                
				orgS.setHorarioNotif (orgLista[i].horarioNotif) ;                                                
				orgS.setLimitacion (orgLista[i].limitacion) ;                                                     
				orgS.setLinAccion (orgLista[i].linAccion) ;                                                      
				orgS.setLocalidad (orgLista[i].localidad) ;                                                      
				orgS.setModalidad (orgLista[i].modalidad) ;                                                      
				orgS.setNitId (orgLista[i].nitId) ;                                                            
				orgS.setNombreEmp (orgLista[i].nombreEmp) ;                                                      
				orgS.setNombreInterOS (orgLista[i].nombreInterOS) ;                                                    
				orgS.setProdServ (orgLista[i].prodServ) ;                                                       
				orgS.setPromedio (orgLista[i].promedio) ;                                                        
				orgS.setTelefonoIOS (orgLista[i].telefonoIOS) ;                                                    
				orgS.setTemaAsesorar (orgLista[i].temaAsesorar) ;                                                   
				orgS.setTransporte (orgLista[i].transporte) ;    
				try {
					crearOrgSoc(orgS);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
		}
	}

	private void crearOrgSoc(OrgSocial orgS) {
		// TODO Auto-generated method stub
		if(existe(orgS) && existeUser(orgS.getCorreoIOS())) {
			if(orgS.getCorreoIOS()!=null && orgS.getCorreoIOS().length()>1) {
				User userDoc=new User();
				userDoc.setUsername(orgS.getCorreoIOS());
				userDoc.setPassword("1236");
				Role rolDoc;
				rolDoc=repositoryRol.findByName("Emprendimiento");
				userDoc.setRoles(rolDoc.getId());
				repositoryUser.save(userDoc);
				System.out.println("insertando usuario");
				orgS.setUserId(userDoc.getId());
			}
			if(orgS.getNombreEmp() !=null) {
				orgS = repository.save(orgS);
				System.out.println("insertando estudiante");
			}
		}else {
			OrgSocial actualizar=repository.getByCorreoIOS(orgS.getCorreoIOS());
			mapear(orgS,actualizar);
			repository.save(actualizar);
		}
	}

	private void mapear(OrgSocial orgS, OrgSocial actualizar) {
		// TODO Auto-generated method stub
		actualizar.setActividadEco (orgS.getActividadEco());         
		actualizar.setBarrio(orgS.getBarrio());               
		actualizar.setComunidad(orgS.getComunidad());            
		actualizar.setContacto(orgS.getContacto());               
		actualizar.setCorreoIOS(orgS.getCorreoIOS());            
		actualizar.setCupos (orgS.getCupos()); 
		actualizar.setDireccion (orgS.getDireccion());            
		actualizar.setDisponibilidad (orgS.getDisponibilidad());       
		actualizar.setEmpleados (orgS.getEmpleados());               
		actualizar.setFechaCons (orgS.getFechaCons());            
		actualizar.setGenero (orgS.getGenero());               
		actualizar.setHorarioAtencion (orgS.getHorarioAtencion());      
		actualizar.setHorarioNotif (orgS.getHorarioNotif());            
		actualizar.setLinAccion (orgS.getLinAccion());            
		actualizar.setLocalidad (orgS.getLocalidad());            
		actualizar.setModalidad (orgS.getModalidad());            
		actualizar.setNitId (orgS.getNitId());                  
		actualizar.setNombreEmp (orgS.getNombreEmp());            
		actualizar.setNombreInterOS (orgS.getNombreInterOS());             
		actualizar.setProdServ (orgS.getProdServ());              
		actualizar.setTelefonoIOS (orgS.getTelefonoIOS());          
		actualizar.setTemaAsesorar (orgS.getTemaAsesorar());            
		actualizar.setUserId (orgS.getUserId());   
	}

	private boolean existeUser(String correoIOS) {
		Optional<User> Encontrado = repositoryUser.findByUsername(correoIOS);
		if(Encontrado.isPresent()) {
			System.out.println("Usuario ya se encuentra registrado");
			return false;
		}
		return true;
	}

	private boolean existe(OrgSocial orgS) {
		Optional<OrgSocial> orgEncontrado = repository.findByNombreEmp(orgS.getNombreEmp());
		if(orgEncontrado.isPresent()) {
			System.out.println("Estudiante ya se encuentra registrado");
			return false;
		}
		return true;
	}

	public void crearOrg(OrgSocial orgS) throws Exception {
		// TODO Auto-generated method stub
        repository.save(orgS);
		
	}

	public void deleteById(long id) {
		// TODO Auto-generated method stub
		OrgSocial org = repository.getById(id);
		
		repository.delete(org);
		
	}

	public OrgSocial getById(long id) {
		// TODO Auto-generated method stub
		OrgSocial org = repository.getById(id);
		//return repository.getById(id);
		return org;
	}


}
