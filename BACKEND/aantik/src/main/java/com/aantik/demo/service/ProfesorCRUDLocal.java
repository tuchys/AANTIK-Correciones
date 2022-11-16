package com.aantik.demo.service;

import com.aantik.demo.entidad.Profesor;

public interface ProfesorCRUDLocal{
	public void crearProfesor(Profesor profesor) throws Exception;
	public Iterable<Profesor> getAll();
	public boolean existe(Profesor docente) throws Exception;
}
