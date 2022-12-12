package com.aantik.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.model.ModAsig;
import com.aantik.demo.HelperClassServices.ERole;
import com.aantik.demo.HelperClassServices.RoleG;
import com.aantik.demo.HelperClassServices.RoleRepository;
import com.aantik.demo.HelperClassServices.UserG;
import com.aantik.demo.entidad.Asignacion;
import com.aantik.demo.repositorio.EstudianteRepositorio;
import com.aantik.demo.repositorio.UsuarioRepositorio;
import com.aantik.demo.repositorio.AsigRepositorio;
@Service
public class AsignacionCRUD implements AsignacionCRUDLocal{
	
	@Autowired
	AsigRepositorio repository;
	@Autowired
	EstudianteRepositorio repositorySt;
	@Autowired
	UsuarioRepositorio repositoryUser;
	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public String crearAsignacion(ModAsig[] asig) throws Exception {
		// TODO Auto-generated method stub
	    Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MMM dd. yyyy. -- H:mm:ss aa");
	    String fecha = formatter.format(date);
	    int i=0;
	    while(asig[i] != null) {
	        Asignacion asignar = new Asignacion();
	        //asignar.setId1(i);
	        asignar.setCorreo(asig[i].correo);
	        Estudiante st=repositorySt.getByCorreo(asig[i].correo);
	        if(st!=null)
	        asignar.setNombre(st.getNombre());
	        asignar.setEmprendimiento(asig[i].emprendimiento);
	        asignar.setId(asig[i].id);
	        asignar.setFecha(fecha);
	        
	        repository.save(asignar);
	        i++;
	    }
		
		return fecha;
	}

	@Override
	public Iterable<Asignacion> getAll() {
		// TODO Auto-generated method stub
		Iterable<Asignacion> asig =  repository.findAll();
		return asig;
	}

	public int cantidad() {
		// TODO Auto-generated method stub
		int cant=0;
		Iterable<Asignacion> asig =  repository.findAll();
		for(Asignacion aux:asig) 
			cant++;
		return cant;
	}

	public ModAsig[] getAllAsg(ModAsig[] asig) {
		// TODO Auto-generated method stub
		Iterable<Asignacion> asigLista =  repository.findAll();
		asig= new ModAsig[cantidad()];
		int i=0;
		for(Asignacion aux:asigLista) {
			asig[i]= new ModAsig();
			asig[i].id1=aux.getId1();
			asig[i].correo=aux.getCorreo();
			asig[i].emprendimiento=aux.getEmprendimiento();
			asig[i].nombre=aux.getNombre();
			asig[i].fecha=aux.getFecha();
			i++;
		}
		return asig;
	}
	
	@Override
	public ModAsig[] getAsigActual(ModAsig[] asig, String fecha) {
		// TODO Auto-generated method stub
		Iterable<Asignacion> asigLista =  repository.getByFecha(fecha);
		int i=0;
		for(Asignacion aux:asigLista) {
			asig[i]= new ModAsig();
			asig[i].id1=aux.getId1();
			asig[i].correo=aux.getCorreo();
			asig[i].emprendimiento=aux.getEmprendimiento();
			asig[i].nombre=aux.getNombre();
			asig[i].fecha=aux.getFecha();
			i++;
		}
		return asig;
	}
	
	public void asignarr(String cor, String emp) {
	    // TODO Auto-generated method stub
	    Estudiante stu = repositorySt.getByCorreo(cor);
	    System.out.println("correo "+cor);
	    System.out.println("correo "+emp);
	    if(stu.getCorreo() != null && emp == stu.emprendimiento) {
	        stu.setEmprendimiento("0");
        try {
            repositorySt.save(stu);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
	}
	    if(stu.getCorreo() != null && emp != null) {
	        stu.setEmprendimiento(emp) ;                                                                                                                                                          
  
	        try {
	            repositorySt.save(stu);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }					
	    }

	}
	/*
	public void dasignarr(ModAsig asi) {
	    // TODO Auto-generated method stub
	    Estudiante stu = repositorySt.getByCorreo(asi.correo);
	    if(asi != null && stu.getCorreo() != null) {
	        stu.setEmprendimiento("0") ;                                                                                                                                                          
  
	        try {
	            repositorySt.save(stu);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }					
	    }
	}*/

	public void rol(String correo) {
		// TODO Auto-generated method stub
	    Estudiante stu = repositorySt.getByCorreo(correo);
	    UserG rol = repositoryUser.getById(stu.getUserId());

	    if(stu.emprendimiento != null) {
	    	stu.status = 1;

	    	Set<RoleG> roles = new HashSet<>();
	    	RoleG userRole = roleRepository.findByName(ERole.ROLE_STUDIANTE)
	    	.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
	    	roles.add(userRole);
	    	rol.setRoles(roles);
	    	
	        try {
	        	repositorySt.save(stu);
	            //repositoryUser.save(rol);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }					
	    }else
	    	//Estudiante pre
	    if(stu.emprendimiento == null) {
	    	if(stu.status != 0) {
	    		stu.status = 0;
	    		repositorySt.save(stu);
		    	Set<RoleG> roles = new HashSet<>();
		    	RoleG userRole = roleRepository.findByName(ERole.ROLE_PREINSCRITO)
		    	.orElseThrow(() -> new RuntimeException("Error: Rol no encontrado."));
		    	roles.add(userRole);
		    	rol.setRoles(roles);
	    	}
				
	    }
				
	}

}
