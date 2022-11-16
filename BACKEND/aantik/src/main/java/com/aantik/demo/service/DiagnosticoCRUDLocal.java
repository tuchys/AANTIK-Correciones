package com.aantik.demo.service;

import com.aantik.demo.entidad.Diagnostico;
import com.aantik.demo.entidad.Preguntas_Dig;
import com.aantik.demo.model.ModDGV;

public interface DiagnosticoCRUDLocal {
	public void crearDiagnostico(ModDGV diag) throws Exception;
	public Iterable<Diagnostico> getAll();
	public Iterable<Diagnostico> getNoRespondidas(Iterable<Preguntas_Dig> listaPreg,Diagnostico dg_actual);
}
