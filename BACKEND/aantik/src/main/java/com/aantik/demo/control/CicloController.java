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
import com.aantik.demo.entidad.Ciclo;
import com.aantik.demo.service.CicloCRUD;



@CrossOrigin(origins = "*", maxAge = 3600)

@Controller

@RequestMapping("/api")

public class CicloController {
	@Autowired CicloCRUD servCiclo;

    @GetMapping("/-")
    public ResponseEntity<Iterable<Ciclo>> cicloGet() {
    	 
    	try {
    	Iterable<Ciclo> res = servCiclo.getAll();


    	return new ResponseEntity<Iterable<Ciclo>>  (res, HttpStatus.OK);
    	} catch (Exception e) {
    		// TODO Auto-generated catch block
    		//e.printStackTrace();
    		System.out.println("Usuario no existe"+e);
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    	}
    	
    	}
    

    
           
 }
    


