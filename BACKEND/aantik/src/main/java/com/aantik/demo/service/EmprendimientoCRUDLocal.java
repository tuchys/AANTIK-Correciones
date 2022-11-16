package com.aantik.demo.service;

import com.aantik.demo.entidad.Emprendimiento;
import com.aantik.demo.model.ModEmprendimiento;

public interface EmprendimientoCRUDLocal {
	public Emprendimiento crearEmprendimiento(Emprendimiento empren) throws Exception;
	public Iterable<Emprendimiento> getAll();
	public void saveAll(ModEmprendimiento[] empLista);
}
