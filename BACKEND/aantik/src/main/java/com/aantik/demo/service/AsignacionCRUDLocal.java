package com.aantik.demo.service;

import com.aantik.demo.entidad.Asignacion;
import com.aantik.demo.model.ModAsig;


public interface AsignacionCRUDLocal {
	public Asignacion crearAsignacion(ModAsig[] asig) throws Exception;
	public Iterable<Asignacion> getAll();

}
