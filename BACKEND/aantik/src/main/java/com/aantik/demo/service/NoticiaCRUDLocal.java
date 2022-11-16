package com.aantik.demo.service;


import com.aantik.demo.entidad.Noticia;
import com.aantik.demo.model.NoticiaEs;


public interface NoticiaCRUDLocal {
	public Noticia crearNoticia(NoticiaEs noti) throws Exception;
	public Iterable<Noticia> getAll();
	public void deleteById(long id);

}
