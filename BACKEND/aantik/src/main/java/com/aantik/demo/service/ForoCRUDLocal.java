package com.aantik.demo.service;


import com.aantik.demo.entidad.Foro;
import com.aantik.demo.model.ModForo;


public interface ForoCRUDLocal {
	public Foro crearNoticia(ModForo noti) throws Exception;
	public Iterable<Foro> getAll();


}
