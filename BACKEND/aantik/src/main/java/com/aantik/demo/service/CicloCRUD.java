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
		boolean estado=false;
        Ciclo cic = new Ciclo(cii.nombre, estado);
        repository.save(cic);			
		return null;
	}

	@Override
	public Iterable<Ciclo> getAll() {
		Iterable<Ciclo> cii =  repository.findAll();
		
		return cii;
	}

	@Override
	public ModCiclo[] getAllCiclos() {
		// TODO Auto-generated method stub
		ModCiclo[] lista= new ModCiclo[getCantidad()];
		Iterable<Ciclo> ciclos=getAll();
		int i=0;
		for(Ciclo aux:ciclos){
			lista[i]=new ModCiclo();
			lista[i].id=aux.getId();
			lista[i].nombre=aux.getPeriodo();
			if(aux.getEstado() == true)
				lista[i].estado="Activo";
			else
				lista[i].estado="Inactivo";
			i++;
		}
		return lista;
	}

	@Override
	public int getCantidad() {
		// TODO Auto-generated method stub
		Iterable<Ciclo> ciclos=getAll();
		int cantidad=0;
		for(Ciclo aux:ciclos)
			cantidad++;
		return cantidad;
	}

	@Override
	public void borrarCiclo(long id) {
		// TODO Auto-generated method stub
		Ciclo borrar=repository.getById(id);
		repository.delete(borrar);
	}

	@Override
	public void cambiarEstado(long id) {
		// TODO Auto-generated method stub
		Iterable<Ciclo> activos=repository.getByEstado(true);
		Ciclo actualiza=repository.getById(id);
		actualiza.setEstado(true);
		if(activos != null) {
			for(Ciclo act:activos) {
				act.setEstado(false);
				repository.save(actualiza);
			}
		}
		repository.save(actualiza);	
	}

	

	

}
