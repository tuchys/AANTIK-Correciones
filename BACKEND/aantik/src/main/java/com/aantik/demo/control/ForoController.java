package com.aantik.demo.control;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aantik.demo.model.ModForo;
import com.aantik.demo.entidad.Foro;
import com.aantik.demo.repositorio.foroRepositorio;
import com.aantik.demo.service.ForoCRUD;


@CrossOrigin(origins = "*", maxAge = 3600)

@Controller

@RequestMapping("/api")

public class ForoController {
	@Autowired foroRepositorio foroRepositorio;
	@Autowired ForoCRUD servForo;
    @PostMapping("/foro")
    public ResponseEntity<?> foritoo(@RequestBody ModForo update) {  
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
     String fecha = formatter.format(date);
    System.out.println("Current date: "+ fecha); 
    
    System.out.println("Encargado: " + update.encargado);
    
    update.fecha=fecha;
    
    Foro foro = new Foro(update.id, update.pregunta, update.encargado, update.fecha, update.correo);

    foroRepositorio.save(foro);
    
    return ResponseEntity.ok("ok");
    }
    @GetMapping("/foroEdit")
    public ResponseEntity<Iterable<Foro>> noticiaSetAll() {
    	 
    	try {
    	Iterable<Foro> res = servForo.getAll();


    	return new ResponseEntity<Iterable<Foro>>  (res, HttpStatus.OK);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		//e.printStackTrace();
    		System.out.println("Usuario no existe"+e);
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    	}
    
    @PostMapping("/foroEmp")
    public ResponseEntity<?> foritoo0(@RequestBody ModForo update) {  
    Date date = new Date();
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
     String fecha = formatter.format(date);
    System.out.println("Current date: "+ fecha); 
    
    System.out.println("Encargado: " + update.encargado);
    
    update.fecha=fecha;
    
    Foro foro = new Foro(update.id, update.pregunta, update.encargado, update.fecha, update.correo);

    foroRepositorio.save(foro);
    
    return ResponseEntity.ok("ok");
    }
    
           
 }
    


