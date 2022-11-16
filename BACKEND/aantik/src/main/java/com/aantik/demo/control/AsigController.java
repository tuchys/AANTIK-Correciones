package com.aantik.demo.control;


import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

//import javax.validation.Valid;

import org.apache.logging.log4j.message.StringFormattedMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;

import com.aantik.demo.model.ModAsig;
import com.aantik.demo.service.AsignacionCRUD;
import com.aantik.demo.entidad.Asignacion;
//import com.aantik.demo.repositorio.asigRepositorio;
import com.aantik.demo.match.AsignacionF;
import com.aantik.demo.match.Match;


@Controller

@RequestMapping("/api")

public class AsigController {
	@Autowired 
	private AsignacionCRUD asigRepositorio;
    @GetMapping("/asignacionNueva")
    public ResponseEntity<Iterable<Asignacion>> asigancion() {
    	try {

    AsignacionF asigna = new AsignacionF();     
    	
    ModAsig asig[] = new ModAsig[20];
    
    asigna.inicial();
    
    asig=asigna.asig;

    asigRepositorio.crearAsignacion(asig);    //asigRepositorio.save(asig);
    Iterable<Asignacion> res = asigRepositorio.getAll();
    return new ResponseEntity<Iterable<Asignacion>>  (res, HttpStatus.OK);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		System.out.println("Usuario no existe"+e);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
    
    }
    


}