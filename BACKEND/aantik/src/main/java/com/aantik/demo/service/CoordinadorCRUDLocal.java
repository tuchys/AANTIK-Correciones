package com.aantik.demo.service;

import com.aantik.demo.entidad.Coordinador;

public interface CoordinadorCRUDLocal {
	public Coordinador crearCoordinador(Coordinador coord) throws Exception;
	public Iterable<Coordinador> getAll();
}
