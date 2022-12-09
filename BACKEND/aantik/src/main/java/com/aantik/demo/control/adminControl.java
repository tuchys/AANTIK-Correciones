package com.aantik.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.aantik.demo.model.ModCiclo;
import com.aantik.demo.model.ModCoordinador;
import com.aantik.demo.model.ModIndicadorBench;
import com.aantik.demo.model.ModOrgSocial;
import com.aantik.demo.service.BenchmarkingExcelService;
import com.aantik.demo.service.CicloCRUD;
import com.aantik.demo.service.CoordinadorCRUD;
import com.aantik.demo.service.OrgSocialCRUD;

@Controller
public class adminControl {
	
	@Autowired
	OrgSocialCRUD orgScService;
	@Autowired
	CicloCRUD cicloSer;
	@Autowired
	CoordinadorCRUD coordService;
	
    @Autowired
    BenchmarkingExcelService BenService;
	
	@PostMapping("/getOS-adm")
	public ResponseEntity<ModOrgSocial> sendOrgSocial(@RequestParam String idOrg) { 
		long idOS=Long.parseLong(idOrg);
		System.out.println("RECIBIENDO..."+idOrg);
		ModOrgSocial orgSoc=new ModOrgSocial();
		orgSoc=orgScService.getById(idOS);
		if(orgSoc != null) {
		System.out.println("enviando organizacion social a front");
			return new ResponseEntity<ModOrgSocial>  (orgSoc, HttpStatus.OK);
		}else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	
	 @PostMapping("/updateOrgSoc")
	public ResponseEntity<?> actualizarOrgSoc(@RequestBody ModOrgSocial orgSocUpd) {
		 System.out.println("actuasliza"+orgSocUpd.nombreEmp);
		 orgScService.actualizar(orgSocUpd);
	    return ResponseEntity.ok("ok");	    
	 }
	 
	 @GetMapping("/getIndicadores")
	public ResponseEntity<ModIndicadorBench[]> getIndicadoresBench( ) { 
		System.out.println("RECIBIENDO...");
		int tamanio=BenService.cantidad();
		ModIndicadorBench[] indicadores=new ModIndicadorBench[tamanio];
		indicadores=BenService.getAllIndicadores(indicadores);
		
		if(indicadores != null) {
			return new ResponseEntity<ModIndicadorBench[]>  (indicadores, HttpStatus.OK);
		}else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@GetMapping("/getListIndicadores")
	public ResponseEntity<String[]> getListaIndicadoresBench( ) { 
		 int tamanio=BenService.cantidadInd();
		 String [] listaInd = new String[tamanio];
		 listaInd=BenService.getListaInd(listaInd);
		 System.out.println("----"+tamanio);
		return new ResponseEntity<String[]>  (listaInd, HttpStatus.OK);
	}
	
	@PostMapping("/delIndc")
	public ResponseEntity<?> borraInd(@RequestParam long indicadorId) {
		
		 System.out.println("eliminar "+indicadorId);
		 BenService.deleteIndicador(indicadorId);
		return new ResponseEntity<Object> (HttpStatus.OK);    
	}
	
	@PostMapping("/addIndc")
	public ResponseEntity<?> saveInd(@RequestBody ModIndicadorBench indicador) {
		
		 System.out.println("actuasliza"+indicador.nombre);
		 BenService.addIndicador(indicador);
		return new ResponseEntity<Object> (HttpStatus.OK);    
	}
		
	 @GetMapping("/getCiclos")
	public ResponseEntity<ModCiclo[]> getCiclos( ) { 
		System.out.println("RECIBIENDO...");
		int tam=cicloSer.getCantidad();
		ModCiclo[] ciclo=new ModCiclo[tam];
		ciclo=cicloSer.getAllCiclos();
		
		//orgSoc=orgScService.getById(idOS);
		if(ciclo != null) {
			return new ResponseEntity<ModCiclo[]>  (ciclo, HttpStatus.OK);
		}else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	
	@PostMapping("/addCiclo")
	public ResponseEntity<?> addCiclo(@RequestBody ModCiclo cicloAdd) {
		 try {
			cicloSer.crearCiclo(cicloAdd);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("actuasliza"+cicloAdd.nombre);
		return new ResponseEntity<Object> (HttpStatus.OK);    
	}
	
	@PostMapping("/delCiclo")
	public ResponseEntity<?> borraCiclo(@RequestParam long cicloId) {
		
		 System.out.println("actuasliza"+cicloId);
		 cicloSer.borrarCiclo(cicloId);
		return new ResponseEntity<Object> (HttpStatus.OK);    
	}
	
	@PostMapping("/estadoCiclo")
	public ResponseEntity<?> activaCiclo(@RequestParam long cicloId) {		
		 System.out.println("actuasliza"+cicloId);
		 cicloSer.cambiarEstado(cicloId);
		return new ResponseEntity<Object> (HttpStatus.OK);    
	}
	
	@PostMapping("/getCO-adm")
	public ResponseEntity<ModCoordinador> sendCoordinador(@RequestParam String idCoord) { 
		long idCO=Long.parseLong(idCoord);
		System.out.println("RECIBIENDO..."+idCoord);
		ModCoordinador coord=new ModCoordinador();
		coord=coordService.getById(idCO);
		if(coord != null) {
		System.out.println("enviando organizacion social a front");
			return new ResponseEntity<ModCoordinador>  (coord, HttpStatus.OK);
		}else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	 @PostMapping("/editCoord")
	public ResponseEntity<?> editCoord(@RequestBody ModCoordinador coord) {

		 coordService.actualizar(coord);
	    return ResponseEntity.ok("ok");	    
	 }
}
