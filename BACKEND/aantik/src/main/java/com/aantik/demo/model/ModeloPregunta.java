package com.aantik.demo.model;

public class ModeloPregunta {
	public String codigo;
	public String pregunta;
	public String insump;
	public boolean automatica=false; //se puede calificar automaticamente
	public ModRubrica rub[]=new ModRubrica[5];
}
