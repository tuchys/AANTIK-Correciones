package com.aantik.demo.service;

import com.aantik.demo.entidad.CIIU;
import com.aantik.demo.entidad.Ciiu_Emp;

public interface CiiuCRUDLocal {
	public CIIU crearCIIU(CIIU ciiu) throws Exception;
	public Iterable<CIIU> getAll();
	public Iterable<Ciiu_Emp> getAllCE();
}
