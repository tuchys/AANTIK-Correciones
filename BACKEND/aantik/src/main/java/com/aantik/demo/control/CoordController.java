package com.aantik.demo.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.aantik.demo.entidad.Coordinador;

import com.aantik.demo.model.ModBench;
import com.aantik.demo.model.ModCoordinador;
import com.aantik.demo.model.ModOrgSocial;
import com.aantik.demo.model.ModelBenchAux;
import com.aantik.demo.model.encuestaPre;
import com.aantik.demo.repositorio.PreguntasRepository;
import com.aantik.demo.service.BenchmarkingExcelService;
import com.aantik.demo.service.CoordinadorCRUD;
import com.aantik.demo.service.DiagnosticoCRUD;

import com.aantik.demo.service.PreguntaCRUD;
import com.aantik.demo.service.PreguntaExcelService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class CoordController {
	@Autowired
	CoordinadorCRUD coordService;

	
	@PostMapping("/addCoord")
	public ResponseEntity<?> addCoord(@RequestBody ModCoordinador update) throws Exception {
		
		System.out.println(update.nombre);
		Coordinador coord = new Coordinador(update.id, update.nombre, update.correo, update.asignatura);
		coordService.crearCoordinador(coord);

		return ResponseEntity.ok("ok");
	}
	
	@PostMapping("/coordDelete")
    public ResponseEntity<?> coordDelete(@RequestBody ModCoordinador update) {  
    
    long id = update.id;
    System.out.println(update.id);
    
    coordService.deleteById(id);
    
    return ResponseEntity.ok("ok");
    }
	
	@GetMapping("/getCoord")
	public ResponseEntity<Iterable<Coordinador>> coordGet() {

		try {
			Iterable<Coordinador> res = coordService.getAll();
			return new ResponseEntity<Iterable<Coordinador>>(res, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Usuario no existe" + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	 @PostMapping("/editCoord")
	public ResponseEntity<?> editCoord(@RequestBody ModCoordinador coord) {

		 coordService.actualizar(coord);
	    return ResponseEntity.ok("ok");	    
	 }
    
}
