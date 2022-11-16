package com.aantik.demo.control;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.xml.crypto.Data;

//import javax.validation.Valid;

import org.apache.logging.log4j.message.StringFormattedMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;

import com.aantik.demo.cargaUsuarios.leerDocentes;
import com.aantik.demo.cargaUsuarios.leerEstudiantes;
import com.aantik.demo.entidad.Diagnostico;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.entidad.Profesor;
import com.aantik.demo.model.ModDGRes;
import com.aantik.demo.model.ModDocente;
import com.aantik.demo.model.ModEmprendimiento;
import com.aantik.demo.model.ModEstudLiv;
import com.aantik.demo.model.ModEstudiante;
import com.aantik.demo.model.ModOrgSocial;
import com.aantik.demo.model.Mpreinscrito;
import com.aantik.demo.model.actualizarDatosEs;
import com.aantik.demo.model.gestEstudiantes;
import com.aantik.demo.service.EstudianteCRUD;
import com.google.gson.Gson;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController

//RequestMapping("/datos")

public class EstController {
	
	@Autowired
	EstudianteCRUD servcioEst;
	
	@PostMapping("/datosEs")
	public ResponseEntity<?> processForgotPassword(@RequestBody actualizarDatosEs update) {

	System.out.println("Tel: " + update.getTelefono());

    System.out.println("Localidad: " + update.getNotif());
	return ResponseEntity.ok("ok");
	}
	
    @GetMapping("/preinsCargaM")
	public ResponseEntity<Estudiante[]> cargaPreins() {
		Estudiante est[] = new Estudiante[2];
		try {
			Mpreinscrito [] preLista = new Mpreinscrito[500];
			leerEstudiantes excelStu = new leerEstudiantes();
			FileInputStream fis2;
			int cant=0;
			try {
				fis2 = new FileInputStream(new File("preinscritos.xlsx"));
				//tejido.leerTejido(fis2,CIIUlista);
				excelStu.getPreinscritos(fis2,preLista);
				System.out.println(cant);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Actualizando "+cant+" datos cod CIIU");
				servcioEst.saveAllPre(preLista,cant);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return new ResponseEntity<Estudiante[]>(est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

    @GetMapping("/studCargaM")
	public ResponseEntity<Estudiante[]> cargaStu() {
		Estudiante est[] = new Estudiante[2];
		try {
			ModEstudiante [] estLista = new ModEstudiante[500];
			leerEstudiantes excelStu = new leerEstudiantes();
			FileInputStream fis2;
			int cant=0;
			try {
				fis2 = new FileInputStream(new File("resEncuesta.xlsx"));
				cant=excelStu.getInscritos(fis2,estLista);
				System.out.println(cant);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Actualizando "+cant+" datos cod CIIU");
				servcioEst.saveAllstud(estLista,cant);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return new ResponseEntity<Estudiante[]>(est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/gesStu")
    public ResponseEntity<gestEstudiantes> obtenerUsuarios(){
    	try {
			gestEstudiantes resp = new gestEstudiantes();
			servcioEst.getGestStud(resp);
    		return new ResponseEntity<gestEstudiantes>(resp, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			System.out.println("Falla en gestion usuario"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    

}
