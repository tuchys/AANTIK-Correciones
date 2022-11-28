package com.aantik.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aantik.demo.entidad.Coordinador;
import com.aantik.demo.entidad.Emprendimiento;
import com.aantik.demo.model.ModCoordinador;
import com.aantik.demo.repositorio.CoordinadorRepositorio;

@Service
public class CoordinadorCRUD implements CoordinadorCRUDLocal{
	
	@Autowired
	CoordinadorRepositorio repository;

	private boolean checkCoordinadorExiste(Coordinador coordinador) throws Exception {
		Optional<Coordinador> coordinadorEncontrado = repository.findById(coordinador.getId());
		if(coordinadorEncontrado.isPresent()) {
			throw new Exception("Usuario ya se encuentra registrado");
		}
		return true;
	}
	
	
	@Override
	public Coordinador crearCoordinador(Coordinador coord) throws Exception {
		if(checkCoordinadorExiste(coord)) {
			coord = repository.save(coord);
		}
		return coord;
	}

	@Override
	public Iterable<Coordinador> getAll() {
        return repository.findAll();
	}


	public void deleteById(long id) {
		// TODO Auto-generated method stub
		Coordinador coord = repository.getById(id);
		
		repository.delete(coord);
		
	}
	
	public ModCoordinador getById(long id) {
		// TODO Auto-generated method stub
		Coordinador coord = repository.getById(id);
		ModCoordinador coordRet= new ModCoordinador();
		if(coord != null) {
			coordRet.nombre=coord.getNombre();         
			coordRet.correo=coord.getCorreo();               
			coordRet.asignatura=coord.getAsignatura();            
		}
		return coordRet;
	}


	public void actualizar(ModCoordinador coordi) {
	    // TODO Auto-generated method stub
	    Coordinador coord=repository.getById(coordi.id);
	    if(coordi != null) {
	        coord.setNombre (coordi.nombre) ;                                                   
	        coord.setCorreo (coordi.correo) ;                                                         
	        coord.setAsignatura (coordi.asignatura) ;                                                                                                        
  
	        try {
	            repository.save(coord);
	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }					
	    }
	}
}
