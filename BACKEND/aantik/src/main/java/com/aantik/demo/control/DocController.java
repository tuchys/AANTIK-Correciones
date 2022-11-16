package com.aantik.demo.control;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

//import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import com.aantik.demo.cargaUsuarios.leerDocentes;
import com.aantik.demo.entidad.CIIU;
import com.aantik.demo.entidad.Profesor;
import com.aantik.demo.model.ModCiiuXemp;
import com.aantik.demo.model.ModDocente;
import com.aantik.demo.model.actDatosDoc;
import com.aantik.demo.model.tejidoSocial;
import com.aantik.demo.service.ProfesorCRUD;
import com.aantik.demo.tejido.leerExcelTejido;

@CrossOrigin(origins = "*", maxAge = 3600)

@Controller
public class DocController {
	@Autowired
	ProfesorCRUD servDoc;
	
    @PostMapping("/datosDoc")
    public ResponseEntity<?> processForgotPassword(@RequestBody actDatosDoc update) {

    System.out.println("Tel: " + update.getTelefono());

    System.out.println("Localidad: " + update.getLocalidad());
    return ResponseEntity.ok("ok");
    }
    
    @GetMapping("/docCargaM")
	public ResponseEntity<Profesor[]> sendCiiu() {
		Profesor est[] = new Profesor[2];
		try {
			ModDocente [] docLista = new ModDocente[50];
			leerDocentes excelDoc= new leerDocentes();
			FileInputStream fis2;
			int cant=0;
			try {
				fis2 = new FileInputStream(new File("Datos basicos-formato.xlsx"));			
				cant=excelDoc.getDocente(fis2,docLista);
				System.out.println(cant);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Actualizando "+cant+" datos cod CIIU");
				servDoc.saveAll(docLista,cant);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return new ResponseEntity<Profesor[]>(est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
@PostMapping("/addDoc")
	
	public ResponseEntity<?> addDoc(@RequestBody ModDocente update) throws Exception {

		
		Profesor pro = new Profesor(update.id, update.nombre, update.vinculacion, update.titulo, update.especialidad,
				update.asignatura, update.telefono, update.correo, update.oficina, update.direcRes,
				update.localidad, update.sectoEc, update.hisAse, update.contacto, update.lineaAc,
				update.secEco2, update.tipoOS, update.horarioNotif, update.horarioAtencion, update.nOdisponibilidad,
				update.limitacion);
		
		servDoc.crearProfesor(pro);
		return ResponseEntity.ok("ok");
	}
	
	@PostMapping("/editDoc")
	
	public ResponseEntity<?> docEdit(@RequestBody ModDocente update) throws Exception {

		long id = update.id;
		servDoc.deleteById(id);
		
		Profesor pro = new Profesor(update.id, update.nombre, update.vinculacion, update.titulo, update.especialidad,
				update.asignatura, update.telefono, update.correo, update.oficina, update.direcRes,
				update.localidad, update.sectoEc, update.hisAse, update.contacto, update.lineaAc,
				update.secEco2, update.tipoOS, update.horarioNotif, update.horarioAtencion, update.nOdisponibilidad,
				update.limitacion);
		
		servDoc.editDoc(pro);
		return ResponseEntity.ok("ok");
	}
	
	@PostMapping("/docDelete")
    public ResponseEntity<?> orgDelete(@RequestBody ModDocente update) {  
    
    long id = update.id;
    
    servDoc.deleteById(id);
    
    return ResponseEntity.ok("ok");
    }
	
	@GetMapping("/getDoc")
	public ResponseEntity<Iterable<Profesor>> orgSet() {
		try {
			Iterable<Profesor> res = servDoc.getAll();
			return new ResponseEntity<Iterable<Profesor>>(res, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Usuario no existe" + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}

}