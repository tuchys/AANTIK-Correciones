package com.aantik.demo.service;

import java.util.Optional; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.OrgSocial;
import com.aantik.demo.entidad.Role;
import com.aantik.demo.entidad.User;
import com.aantik.demo.model.ModEmprendimiento;
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
				orgS.setTipoOS(orgLista[i].tipoOS);
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

	public void crearOrgSoc(OrgSocial orgS) {
		// TODO Auto-generated method stub
		if(existe(orgS) && existeUser(orgS.getCorreoIOS())) {
			if(orgS.getCorreoIOS()!=null && orgS.getCorreoIOS().length()>1) {
				User userDoc=new User();
				userDoc.setUsername(orgS.getCorreoIOS());
				userDoc.setPassword("1236");
				Role rolDoc;
				rolDoc=repositoryRol.findByName("OrgSocial");
				userDoc.setRoles(rolDoc.getId());
				repositoryUser.save(userDoc);
				System.out.println("insertando usuario");
				orgS.setUserId(userDoc.getId());
			}
			if(orgS.getNombreEmp() !=null) {
				orgS = repository.save(orgS);
				System.out.println("insertando OrgSocial");
			}
		}else {
			OrgSocial actualizar=repository.getByCorreoIOS(orgS.getCorreoIOS());
			if(actualizar!=null) {
				actualizar=mapear(orgS,actualizar);
				repository.save(actualizar);
			}else
				System.out.println("noi actualiza--------");
			
		}
	}

	private OrgSocial mapear(OrgSocial orgS, OrgSocial actualizar) {
		System.out.println("actualiza-----------------"+orgS.getComunidad());
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
		actualizar.setTipoOS(orgS.getTipoOS());
		actualizar.setNombreEmp (orgS.getNombreEmp());            
		actualizar.setNombreInterOS (orgS.getNombreInterOS());             
		actualizar.setProdServ (orgS.getProdServ());              
		actualizar.setTelefonoIOS (orgS.getTelefonoIOS());          
		actualizar.setTemaAsesorar (orgS.getTemaAsesorar());            
		actualizar.setUserId (orgS.getUserId());                                                 
		actualizar.setTransporte (orgS.isTransporte()) ;                                        
		actualizar.setPromedio(orgS.isPromedio()) ;                                                    
		actualizar.setExperiencia(orgS.isExperiencia());                                                
		actualizar.setLimitacion(orgS.isLimitacion()); 
		return actualizar;
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
			System.out.println("Org Social ya se encuentra registrado");
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

	public ModOrgSocial getById(long id) {
		// TODO Auto-generated method stub
		OrgSocial org = repository.getById(id);
		ModOrgSocial orgRet= new ModOrgSocial();
		if(org != null) {
			orgRet.actividadEco=org.getActividadEco();         
			orgRet.barrio=org.getBarrio();               
			orgRet.comunidad=org.getComunidad();            
			orgRet.contacto=org.getContacto();               
			orgRet.correoIOS=org.getCorreoIOS();            
			orgRet.cupos=org.getCupos(); 
			orgRet.direccion=org.getDireccion();            
			orgRet.disponibilidad=org.getDisponibilidad();       
			orgRet.empleados=org.getEmpleados();               
			orgRet.experiencia=org.isExperiencia();     
			orgRet.fechaCons=org.getFechaCons();            
			orgRet.genero=org.getGenero();                   
			orgRet.horarioAtencion=org.getHorarioAtencion();      
			orgRet.horarioNotif=org.getHorarioNotif();        
			orgRet.limitacion=org.isLimitacion();           
			orgRet.linAccion=org.getLinAccion();                        
			orgRet.localidad=org.getLocalidad();
			orgRet.modalidad=org.getModalidad();
			orgRet.nitId=org.getNitId();  
			orgRet.tipoOS=org.getTipoOS();
			orgRet.nombreEmp=org.getNombreEmp();
			orgRet.nombreInterOS=org.getNombreInterOS();
			orgRet.prodServ=org.getProdServ();
			orgRet.promedio=org.isPromedio();
			orgRet.telefonoIOS=org.getTelefonoIOS();
			orgRet.temaAsesorar=org.getTemaAsesorar();
			orgRet.transporte=org.isTransporte();
		}
		return orgRet;
	}

	public void actualizar(ModOrgSocial orgSocUpd) {
	    // TODO Auto-generated method stub
	    OrgSocial orgS=repository.getById(orgSocUpd.id);
	    if(orgSocUpd!=null) {
	        orgS.setActividadEco (orgSocUpd.actividadEco) ;                                                   
	        orgS.setBarrio (orgSocUpd.barrio) ;                                                         
	        orgS.setComunidad (orgSocUpd.comunidad) ;                                                      
	        orgS.setContacto (orgSocUpd.contacto) ;                                                       
	        orgS.setCorreoIOS (orgSocUpd.correoIOS) ;                                                      
	        orgS.setCupos (orgSocUpd.cupos) ;                                                          
	        orgS.setDireccion (orgSocUpd.direccion) ;                                                      
	        orgS.setDisponibilidad (orgSocUpd.disponibilidad) ;                                                 
	        orgS.setEmpleados (orgSocUpd.empleados) ;                                                      
	        orgS.setExperiencia (orgSocUpd.experiencia) ;                                                    
	        orgS.setFechaCons (orgSocUpd.fechaCons) ;                                                      
	        orgS.setGenero (orgSocUpd.genero) ;                                                         
	        orgS.setHorarioAtencion (orgSocUpd.horarioAtencion) ;                                                
	        orgS.setHorarioNotif (orgSocUpd.horarioNotif) ;                                                
	        orgS.setLimitacion (orgSocUpd.limitacion) ;                                                     
	        orgS.setLinAccion (orgSocUpd.linAccion) ;                                                      
	        orgS.setLocalidad (orgSocUpd.localidad) ;                                                      
	        orgS.setModalidad (orgSocUpd.modalidad) ;                                                      
	        orgS.setNitId (orgSocUpd.nitId) ;  
	        orgS.setTipoOS(orgSocUpd.tipoOS);
	        orgS.setNombreEmp (orgSocUpd.nombreEmp) ;                                                      
	        orgS.setNombreInterOS (orgSocUpd.nombreInterOS) ;                                                    
	        orgS.setProdServ (orgSocUpd.prodServ) ;                                                       
	        orgS.setPromedio (orgSocUpd.promedio) ;                                                        
	        orgS.setTelefonoIOS (orgSocUpd.telefonoIOS) ;                                                    
	        orgS.setTemaAsesorar (orgSocUpd.temaAsesorar) ;                                                   
	        orgS.setTransporte (orgSocUpd.transporte) ;    
	        try {
	            repository.save(orgS);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }					
	    }
	}

	public int getCant() {
		// TODO Auto-generated method stub
		Iterable<OrgSocial> lista= repository.findAll();
		int i=0;
		for(OrgSocial aux:lista)
			i++;
		return i;
	}

	public ModEmprendimiento[] getOrgSocMatch(ModEmprendimiento[] OrgSocR) {
		// TODO Auto-generated method stub
		Iterable<OrgSocial> lista= repository.findAll();
		int cantidad=getCant(),i=0;
		//ModEmprendimiento[] OrgSocR = new ModEmprendimiento[cantidad];
		for(OrgSocial aux:lista) {
			OrgSocR[i]= new ModEmprendimiento();
			OrgSocR[i].id=(int) aux.getUserId();
			OrgSocR[i].nombreEmp=aux.getNombreEmp();
			OrgSocR[i].NIT=aux.getNitId();
			OrgSocR[i].fechaCons=aux.getFechaCons();
			OrgSocR[i].direccion=aux.getDireccion();
			OrgSocR[i].localidad=aux.getLocalidad();//****
			OrgSocR[i].barrio=aux.getBarrio();
			OrgSocR[i].temaAsesorar=aux.getTemaAsesorar();
			OrgSocR[i].nombreInterOS=aux.getNombreInterOS();
			OrgSocR[i].telefonoIOS=aux.getTelefonoIOS();
			OrgSocR[i].correoIOS=aux.getCorreoIOS();
			OrgSocR[i].cupos=aux.getCupos();
			OrgSocR[i].empleados=aux.getEmpleados();
			OrgSocR[i].linAccion=aux.getLinAccion();
			OrgSocR[i].actividadEco=aux.getActividadEco();
			OrgSocR[i].prodServ=aux.getProdServ();
			OrgSocR[i].contacto=aux.getContacto();
			OrgSocR[i].experiencia=aux.isExperiencia();//**
			OrgSocR[i].promedio=aux.isPromedio();//**
			OrgSocR[i].horarioNotif=aux.getHorarioNotif();
			OrgSocR[i].modalidad=aux.getModalidad();//**
			OrgSocR[i].disponibilidad=aux.getDisponibilidad();
			OrgSocR[i].horarioAtencion=aux.getHorarioAtencion();
			OrgSocR[i].genero=aux.getGenero();//**
			OrgSocR[i].limitacion=aux.isLimitacion();
			OrgSocR[i].comunidad=aux.getComunidad();
			OrgSocR[i].transporte=aux.isTransporte();//*p
			i++;
		}
		return OrgSocR;
	}


}
