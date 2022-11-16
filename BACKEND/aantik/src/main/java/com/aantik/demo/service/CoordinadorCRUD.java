package com.aantik.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aantik.demo.entidad.Coordinador;
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

}
