package com.aantik.demo.service;


import com.aantik.demo.entidad.Ciclo;
import com.aantik.demo.model.ModCiclo;


public interface CicloCRUDLocal {
	public Ciclo crearCiclo(ModCiclo noti) throws Exception;
	public Iterable<Ciclo> getAll();


}
