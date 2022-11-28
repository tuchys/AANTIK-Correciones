package com.aantik.demo.service;

import com.aantik.demo.entidad.Asignacion;
import com.aantik.demo.model.ModAsig;


public interface AsignacionCRUDLocal {
	public String crearAsignacion(ModAsig[] asig) throws Exception;
	public Iterable<Asignacion> getAll();
	public int cantidad(); 
	public ModAsig[] getAllAsg(ModAsig[] asig);
	public ModAsig[] getAsigActual(ModAsig[] asig,String fecha);
}
