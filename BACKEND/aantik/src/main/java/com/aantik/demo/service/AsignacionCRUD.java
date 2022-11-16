package com.aantik.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Ciiu_Emp;
import com.aantik.demo.model.ModAsig;
import com.aantik.demo.entidad.Asignacion;
import com.aantik.demo.entidad.CIIU;
import com.aantik.demo.repositorio.CiiuRepositorio;
import com.aantik.demo.repositorio.AsigRepositorio;
import com.aantik.demo.repositorio.CiiuEmpRepositorio;

@Service
public class AsignacionCRUD implements AsignacionCRUDLocal{
	
	@Autowired
	AsigRepositorio repository;

	@Override
	public Asignacion crearAsignacion(ModAsig[] asig) throws Exception {
		// TODO Auto-generated method stub
	    Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String fecha = formatter.format(date);
	    int i=0;
	    while(asig[i] != null) {
	        Asignacion asignar = new Asignacion();
	        asignar.setId1(i);
	        asignar.setCorreo(asig[i].correo);
	        asignar.setEmprendimiento(asig[i].emprendimiento);
	        asignar.setId(asig[i].id);
	        asignar.setFecha(fecha);
	        
	        repository.save(asignar);
	        i++;
	    }
		
		return null;
	}

	@Override
	public Iterable<Asignacion> getAll() {
		// TODO Auto-generated method stub
		Iterable<Asignacion> asig =  repository.findAll();
		return asig;
	}
	

	

}
