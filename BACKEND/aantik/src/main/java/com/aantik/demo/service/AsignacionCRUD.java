package com.aantik.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.model.ModAsig;
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

}
