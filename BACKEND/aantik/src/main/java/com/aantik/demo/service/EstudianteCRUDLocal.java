package com.aantik.demo.service;

import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.model.ModEstudiante;
import com.aantik.demo.model.Mpreinscrito;

public interface EstudianteCRUDLocal {
	public void crearEstudiante(Estudiante estd) throws Exception;
	public Iterable<Estudiante> getAll();
	public void saveAll(ModEstudiante[] stlista, int cantSt);
	public void crearPreins(Estudiante preins);
	public void saveAllPre(Mpreinscrito[] preLista, int cant);
	public void saveAllstud(ModEstudiante[] estLista, int cant);
	public Iterable<Estudiante> getInscritos();
	public Iterable<Estudiante> getpreins();
	public int getTamanio(Iterable<Estudiante> insc);
}
