package com.aantik.demo.control;

import java.io.File;
import com.aantik.demo.repositorio.OrgSocialRepositorio;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.aantik.demo.cargaUsuarios.leerEntidades;
import com.aantik.demo.entidad.Noticia;
import com.aantik.demo.entidad.OrgSocial;
import com.aantik.demo.model.ModOrgSocial;
import com.aantik.demo.model.NoticiaEs;
import com.aantik.demo.service.OrgSocialCRUD;

@Controller
public class orgSocController {
	@Autowired
	OrgSocialCRUD orgScService;
	@Autowired
	OrgSocialRepositorio orgScService2;

	@GetMapping("/orgSCargaM")
	public ResponseEntity<ModOrgSocial[]> cargaStu() {
		ModOrgSocial est[] = new ModOrgSocial[2];
		try {
			ModOrgSocial[] orgLista = new ModOrgSocial[50];
			leerEntidades excelOrg = new leerEntidades();
			FileInputStream fis2;
			try {
				fis2 = new FileInputStream(new File("Datos basicos-formato.xlsx"));
				excelOrg.getEntidades(fis2, orgLista);

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				orgScService.saveAll(orgLista);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<ModOrgSocial[]>(est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Usuario no existe" + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}

	@PostMapping("/addOrgSoc")
	public ResponseEntity<?> orgSocGet(@RequestBody ModOrgSocial update) throws Exception {

		OrgSocial org = new OrgSocial(update.id, update.nombreEmp, update.nitId, update.fechaCons, update.direccion,
				update.localidad, update.barrio, update.nombreInterOS, update.telefonoIOS, update.correoIOS,
				update.temaAsesorar, update.cupos, update.empleados, update.linAccion, update.tipoOS,
				update.actividadEco, update.prodServ, update.contacto, update.experiencia, update.promedio,
				update.horarioNotif, update.modalidad, update.disponibilidad, update.horarioAtencion, update.genero,
				update.limitacion, update.comunidad, update.transporte);
		orgScService.crearOrganizacion(org);

		return ResponseEntity.ok("ok");
	}

	
	@GetMapping("/getOrg")
	public ResponseEntity<Iterable<OrgSocial>> orgSet() {

		try {
			Iterable<OrgSocial> res = orgScService.getAll();
			return new ResponseEntity<Iterable<OrgSocial>>(res, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Usuario no existe" + e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}

	}
	
	@PostMapping("/orgDelete")
    public ResponseEntity<?> orgDelete(@RequestBody ModOrgSocial update) {  
    
    long id = update.id;
    
    orgScService.deleteById(id);
    
    return ResponseEntity.ok("ok");
    }
	
	@PostMapping("/orgGetOne")
    public ResponseEntity<?> orgGet(@RequestBody ModOrgSocial update) {
		System.out.println("hola");
    
    System.out.println("ID ES " + update.id);
    
    //OrgSocial res = orgScService.findById(update.id);
    //System.out.println(res);
	//Optional<OrgSocial> orgEncontrado = repository.findById(org.getId());
    //long id = update.id-1;
    
    //ptional<OrgSocial> orgEncontrado = orgScService.findById(id);
    
    //OrgSocial org = orgScService2.findByNitId("1");
    //System.out.println(org.getCorreoIOS());
    //System.out.println(org);
    return ResponseEntity.ok(2);
    //return new ResponseEntity<OrgSocial>(org, HttpStatus.OK);
    
    }
	@PostMapping("/editOrgSoc")
	public ResponseEntity<?> orgSocEdit(@RequestBody ModOrgSocial update) throws Exception {

		long id = update.id;
		System.out.println(id);
		System.out.println(update.nitId);
		System.out.println(update.genero);
	    orgScService.deleteById(id);
		
		OrgSocial org = new OrgSocial(update.id, update.nombreEmp, update.nitId, update.fechaCons, update.direccion,
				update.localidad, update.barrio, update.nombreInterOS, update.telefonoIOS, update.correoIOS,
				update.temaAsesorar, update.cupos, update.empleados, update.linAccion, update.tipoOS,
				update.actividadEco, update.prodServ, update.contacto, update.experiencia, update.promedio,
				update.horarioNotif, update.modalidad, update.disponibilidad, update.horarioAtencion, update.genero,
				update.limitacion, update.comunidad, update.transporte);
		
		orgScService.crearOrganizacion(org);
		System.out.println(update.id);
		System.out.println(update.nitId);
		


		return ResponseEntity.ok("ok");
	}

	
}
