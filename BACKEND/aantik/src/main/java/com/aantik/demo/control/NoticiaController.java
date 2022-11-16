package com.aantik.demo.control;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;  
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aantik.demo.model.NoticiaEs;

import com.aantik.demo.entidad.Noticia;
import com.aantik.demo.repositorio.noticiaRepositorio;
import com.aantik.demo.service.NoticiaCRUD;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)

@Controller

@RequestMapping("/api")

public class NoticiaController {
	@Autowired NoticiaCRUD servNoticia;
    @PostMapping("/noticiaEs")
    public ResponseEntity<?> noticiaGet(@RequestBody NoticiaEs update) {  
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    String fecha = formatter.format(date);
    System.out.println("Current date: "+ fecha); 
    
    System.out.println("Encargado: " + update.encargado);
    
    update.fecha=fecha;
    
    Noticia noticia = new Noticia(update.id, update.titulo, update.noticiaa, update.fuente, update.encargado, update.fecha, update.correo);

    servNoticia.crearNoticia(noticia);
    
    return ResponseEntity.ok("ok");
    }
  
    @GetMapping("/noticias")
    public ResponseEntity<Iterable<Noticia>> noticiaSet() {
    	 
    	try {
    	Iterable<Noticia> res = servNoticia.getAll();

        List<Noticia> res2= new ArrayList<Noticia>();
        List<Noticia> res3= new ArrayList<Noticia>();
        
        res.forEach(res2::add);
        
        Collections.reverse(res2);

        if(res2.size() > 10) {
        res3 = res2.subList(0, 10);

    	return new ResponseEntity<Iterable<Noticia>>  (res3, HttpStatus.OK);
        }else
        	return new ResponseEntity<Iterable<Noticia>>  (res2, HttpStatus.OK);
        
        } catch (Exception e) {
    		// TODO Auto-generated catch block
    		//e.printStackTrace();
    		System.out.println("Usuario no existe"+e);
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    	}
    
    private int sizeof(Iterable<Noticia> res) {
		// TODO Auto-generated method stub
		return 0;
	}

	@GetMapping("/notiEdit")
    public ResponseEntity<Iterable<Noticia>> noticiaSetAll() {
    	 
    	try {
    	Iterable<Noticia> res = servNoticia.getAll();


    	return new ResponseEntity<Iterable<Noticia>>  (res, HttpStatus.OK);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		//e.printStackTrace();
    		System.out.println("Usuario no existe"+e);
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    	}
	
	@PostMapping("/notiDelete")
    public ResponseEntity<?> noticiaDelete(@RequestBody NoticiaEs update) {  

    
    System.out.println("id: " + update.id);
    
    long id = update.id;
    
    servNoticia.deleteById(id);
    
    return ResponseEntity.ok("ok");
    }
    
    
           
 }
    


