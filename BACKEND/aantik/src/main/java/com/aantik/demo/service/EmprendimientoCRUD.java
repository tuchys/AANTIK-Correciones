package com.aantik.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aantik.demo.entidad.Emprendimiento;
import com.aantik.demo.entidad.Role;
import com.aantik.demo.entidad.User;
import com.aantik.demo.model.ModEmprendimiento;
import com.aantik.demo.repositorio.EmprendimientoRepositorio;
import com.aantik.demo.repositorio.RoleRepositorio;
import com.aantik.demo.repositorio.UsuarioRepositorio;

@Service
public class EmprendimientoCRUD implements EmprendimientoCRUDLocal{

	@Autowired
	EmprendimientoRepositorio repository;
	@Autowired
	UsuarioRepositorio repositoryUser;
	@Autowired
	RoleRepositorio repositoryRol;
	
	private boolean checkEmprendimientoExiste(Emprendimiento empren) throws Exception {
		Optional<Emprendimiento> emprenEncontrado = repository.findById(empren.getId());
		if(emprenEncontrado.isPresent()) {
			throw new Exception("Usuario ya se encuentra registrado");
		}
		return true;
	}
	
	@Override
	public Emprendimiento crearEmprendimiento(Emprendimiento empren) throws Exception {
		if(checkEmprendimientoExiste(empren)) {
			empren = repository.save(empren);
		}
		return empren;
	}

	@Override
	public Iterable<Emprendimiento> getAll() {
        return repository.findAll();
	}

	public void saveAll(ModEmprendimiento[] empLista) {
		// TODO Auto-generated method stub
		Emprendimiento empren=new Emprendimiento();
		System.out.println("VERIFICANDO "+empLista.length);
		for(int i =0;i<empLista.length;i++) {
			empren=new Emprendimiento();
			if(empLista[i]!=null) {
				empren.setActividadEco (empLista[i].actividadEco) ;                                                   
				empren.setBarrio (empLista[i].barrio) ;                                                         
				empren.setComunidad (empLista[i].comunidad) ;                                                      
				empren.setContacto (empLista[i].contacto) ;                                                
				empren.setCorreoIE (empLista[i].correoIE) ;                                                       
				empren.setCorreoIOS (empLista[i].correoIOS) ;                                                      
				empren.setCupos (empLista[i].cupos) ;                                                          
				empren.setDireccion (empLista[i].direccion) ;                                                      
				empren.setDisponibilidad (empLista[i].disponibilidad) ;                                                 
				empren.setEmpleados (empLista[i].empleados) ;                                                      
				empren.setExperiencia (empLista[i].experiencia) ;                                                    
				empren.setFechaCons (empLista[i].fechaCons) ;                                                      
				empren.setGenero (empLista[i].genero) ;                                                         
				empren.setHorarioAtencion (empLista[i].horarioAtencion) ;                                                
				empren.setHorarioNotif (empLista[i].horarioNotif) ;                                       
				empren.setInterlocutorEmp (empLista[i].interlocutorEmp) ;                                                
				empren.setLimitacion (empLista[i].limitacion) ;                                                     
				empren.setLinAccion (empLista[i].linAccion) ;                                                      
				empren.setLocalidad (empLista[i].localidad) ;                                                      
				empren.setModalidad (empLista[i].modalidad) ;                                                      
				empren.setNIT (empLista[i].NIT) ;                                                            
				empren.setNombreEmp (empLista[i].nombreEmp) ;                                                      
				empren.setNombreInterOS (empLista[i].nombreInterOS) ;                                                  
				empren.setOrgSocial (empLista[i].orgSocial) ;                                                      
				empren.setProdServ (empLista[i].prodServ) ;                                                       
				empren.setPromedio (empLista[i].promedio) ;                                                 
				empren.setTelefonoIE (empLista[i].telefonoIE) ;                                                     
				empren.setTelefonoIOS (empLista[i].telefonoIOS) ;                                                    
				empren.setTemaAsesorar (empLista[i].temaAsesorar) ;                                                   
				empren.setTransporte (empLista[i].transporte) ;                                            
				try {
					crearEmpr(empren);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}

	private void crearEmpr(Emprendimiento empren) {
		// TODO Auto-generated method stub
		if(existe(empren) && existeUser(empren.getCorreoIE())) {
			if(empren.getCorreoIE()!=null && empren.getCorreoIE().length()>1) {
				User userDoc=new User();
				userDoc.setUsername(empren.getCorreoIE());
				userDoc.setPassword("1236");
				Role rolDoc;
				rolDoc=repositoryRol.findByName("Emprendimiento");
				userDoc.setRoles(rolDoc.getId());
				repositoryUser.save(userDoc);
				System.out.println("insertando usuario");
				empren.setUserId(userDoc.getId());
			}
			if(empren.getNombreEmp() !=null) {
				empren = repository.save(empren);
				System.out.println("insertando estudiante");
			}
		}else {
			Emprendimiento actualizar=repository.getByCorreoIE(empren.getCorreoIE());
			mapear(empren,actualizar);
			repository.save(actualizar);
		}
	}

	private boolean existeUser(String correo) {
		Optional<User> Encontrado = repositoryUser.findByUsername(correo);
		if(Encontrado.isPresent()) {
			System.out.println("Usuario ya se encuentra registrado");
			return false;
		}
		return true;
	}

	private boolean existe(Emprendimiento empren) {
		Optional<Emprendimiento> empEncontrado = repository.findByNombreEmp(empren.getNombreEmp());
		if(empEncontrado.isPresent()) {
			System.out.println("Estudiante ya se encuentra registrado");
			return false;
		}
		return true;
	}

	private void mapear(Emprendimiento empren, Emprendimiento actualizar) {
		// TODO Auto-generated method stub
		actualizar.setActividadEco (empren.getActividadEco());         
		actualizar.setBarrio(empren.getBarrio());               
		actualizar.setComunidad(empren.getComunidad());            
		actualizar.setContacto(empren.getContacto());             
		actualizar.setCorreoIE(empren.getCorreoIE());               
		actualizar.setCorreoIOS(empren.getCorreoIOS());            
		actualizar.setCupos (empren.getCupos()); 
		actualizar.setDireccion (empren.getDireccion());            
		actualizar.setDisponibilidad (empren.getDisponibilidad());       
		actualizar.setEmpleados (empren.getEmpleados());            
		actualizar.setExperiencia (empren.getExperiencia());          
		actualizar.setFechaCons (empren.getFechaCons());            
		actualizar.setGenero (empren.getGenero());               
		actualizar.setHorarioAtencion (empren.getHorarioAtencion());      
		actualizar.setHorarioNotif (empren.getHorarioNotif());    
		actualizar.setInterlocutorEmp (empren.getInterlocutorEmp());      
		actualizar.setLimitacion (empren.getLimitacion());           
		actualizar.setLinAccion (empren.getLinAccion());            
		actualizar.setLocalidad (empren.getLocalidad());            
		actualizar.setModalidad (empren.getModalidad());            
		actualizar.setNIT (empren.getNIT());                  
		actualizar.setNombreEmp (empren.getNombreEmp());            
		actualizar.setNombreInterOS (empren.getNombreInterOS());        
		actualizar.setOrgSocial (empren.getOrgSocial());            
		actualizar.setProdServ (empren.getProdServ());             
		actualizar.setPromedio (empren.getPromedio());              
		actualizar.setTelefonoIE (empren.getTelefonoIE());           
		actualizar.setTelefonoIOS (empren.getTelefonoIOS());          
		actualizar.setTemaAsesorar (empren.getTemaAsesorar());         
		actualizar.setTransporte (empren.getTransporte());           
		actualizar.setUserId (empren.getUserId());   
	}

}
