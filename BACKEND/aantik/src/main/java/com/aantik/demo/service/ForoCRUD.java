package com.aantik.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Foro;
import com.aantik.demo.model.ModForo;
import com.aantik.demo.repositorio.foroRepositorio;


@Service
public class ForoCRUD implements ForoCRUDLocal{
	
	@Autowired
	foroRepositorio repository;

	@Override
	public Foro crearNoticia(ModForo fori) throws Exception {
		// TODO Auto-generated method stub
	    Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String fecha = formatter.format(date);
	    fori.fecha=fecha;

	        Foro forito = new Foro(fori.id, fori.pregunta, fori.encargado, fori.fecha,  fori.correo);
	        repository.save(forito);
	    
		
		return null;
	}

	@Override
	public Iterable<Foro> getAll() {
		// TODO Auto-generated method stub
		Iterable<Foro> foro =  repository.findAll();
		return foro;
	}
	


	

	

}
