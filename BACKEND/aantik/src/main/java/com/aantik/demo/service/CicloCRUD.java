package com.aantik.demo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Ciclo;
import com.aantik.demo.model.ModCiclo;
import com.aantik.demo.repositorio.CicloRepositorio;



@Service
public class CicloCRUD implements CicloCRUDLocal{
	
	@Autowired
	CicloRepositorio repository;

	@Override
	public Ciclo crearCiclo(ModCiclo cii) throws Exception {
		// TODO Auto-generated method stub


	        Ciclo cic = new Ciclo(cii.id, cii.periodo, cii.estado);
	        repository.save(cic);
	    
		
		return null;
	}

	@Override
	public Iterable<Ciclo> getAll() {
		Iterable<Ciclo> cii =  repository.findAll();
		return cii;
	}

	

	

}
