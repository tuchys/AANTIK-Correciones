package com.aantik.demo.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.aantik.demo.entidad.Noticia;
import com.aantik.demo.model.NoticiaEs;
import com.aantik.demo.repositorio.noticiaRepositorio;


@Service
public class NoticiaCRUD implements NoticiaCRUDLocal{
	
	@Autowired
	noticiaRepositorio repository;

	@Override
	public Noticia crearNoticia(NoticiaEs noti) throws Exception {
		// TODO Auto-generated method stub
	    Date date = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
	    String fecha = formatter.format(date);
	    noti.fecha=fecha;

	        Noticia notici = new Noticia(noti.id, noti.titulo, noti.noticiaa, noti.fuente, noti.fecha, noti.encargado, noti.correo);
	        repository.save(notici);
	    
		
		return null;
	}

	@Override
	public Iterable<Noticia> getAll() {
		// TODO Auto-generated method stub
		Iterable<Noticia> noti =  repository.findAll();
		return noti;
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		Noticia noti = repository.getById(id);
		
		repository.delete(noti);
	}

	public void crearNoticia(Noticia noticia) {
		// TODO Auto-generated method stub
		repository.save(noticia);
		
	}


	

	

}
