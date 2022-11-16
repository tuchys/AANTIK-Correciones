package com.aantik.demo.service;

import com.aantik.demo.entidad.RedTejido;

public interface TejidoCRUDLocal{
	public RedTejido crearTejido(RedTejido tejido) throws Exception;
	public Iterable<RedTejido> getAll();
	public boolean existe(RedTejido tejido) throws Exception;

}
