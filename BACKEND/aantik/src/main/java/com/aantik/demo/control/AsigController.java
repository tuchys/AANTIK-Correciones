package com.aantik.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.aantik.demo.model.ModAsig;
import com.aantik.demo.model.ModEmprendimiento;
import com.aantik.demo.service.AsignacionCRUD;
import com.aantik.demo.service.EmprendimientoCRUD;
import com.aantik.demo.service.EstudianteCRUD;
import com.aantik.demo.service.OrgSocialCRUD;
import com.aantik.demo.match.AsignacionF;
import com.aantik.demo.match.AsignacionServ;
import com.aantik.demo.match.EstudianteM;


@Controller
@RequestMapping("/api")
public class AsigController {
	
	@Autowired 
	private AsignacionCRUD asigRepositorio;
	
	@Autowired
	EstudianteCRUD servcioEst;
	
	@Autowired
	OrgSocialCRUD orgScService;
	
	@Autowired
	EmprendimientoCRUD empService;
	
    @GetMapping("/asignacionNueva")
    public ResponseEntity<ModAsig[]> asigancion() {
    	try {	
		    AsignacionF asigna = new AsignacionF();    
		    asigna.inicial();     	    	
		    ModAsig asig[] = new ModAsig[asigna.asignados];		    
		    asig=asigna.asig;
		    ModAsig asig2[] = new ModAsig[asigna.asignados];		 
		    String fecha=asigRepositorio.crearAsignacion(asig); 
		    asig2=asigRepositorio.getAsigActual(asig2,fecha);
		    //Iterable<Asignacion> res = asigRepositorio.getAll();
		    return new ResponseEntity<ModAsig[]>  (asig2, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    
    }
    
    @GetMapping("/histoAsignacion")
    public ResponseEntity<ModAsig[]> asigancionHistorico() {
    	try {	
    		int tam=asigRepositorio.cantidad();
		    ModAsig asig[] = new ModAsig[tam];	    
		    asig=asigRepositorio.getAllAsg(asig);  
		    
		    return new ResponseEntity<ModAsig[]>  (asig, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("ERROR "+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    
    }
    
    @GetMapping("/infoAsigAct")
    public ResponseEntity<EstudianteM[][]> asigancionesActuales() {
    	try {	
		    //cantidad en BD
		    int totalPreins=servcioEst.getCantPreins();
		   //instancia de datos de BD
		    EstudianteM[][] lists=new EstudianteM[2][];
		    lists[1]=servcioEst.getAllPreinsMatch();
		    lists[0]=servcioEst.getAllinsMatch();
 
		    //String fecha=asigRepositorio.crearAsignacion(asig); 
		    //asig2=asigRepositorio.getAsigActual(asig2,fecha);
		    //Iterable<Asignacion> res = asigRepositorio.getAll();
		    return new ResponseEntity<EstudianteM[][]>  (lists, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    
    }
    
    @GetMapping("/asignacionBD")
    public ResponseEntity<ModAsig[]> asigancionBD() {
    	try {	
		    AsignacionServ asigna = new AsignacionServ();
		    //cantidad en BD
		    int totalPreins=servcioEst.getCantPreins();
		    int totalEmpAses=orgScService.getCant()+empService.getCant();
		   //instancia de datos de BD
		    asigna.ins.estudiantes=new EstudianteM[totalPreins];
		    asigna.ins.emprendimientos2=new ModEmprendimiento[totalEmpAses];
		    asigna.ins.estudiantes=servcioEst.getAllPreinsMatch();
		    asigna.ins.emprendimientos2=orgScService.getOrgSocMatch(asigna.ins.emprendimientos2);
		    asigna.ins.emprendimientos2=empService.getemprMatch(asigna.ins.emprendimientos2);
		    //calcular match
		    System.out.println("totasl de entidades a asignar: "+totalEmpAses+"-"+orgScService.getCant()+"-"+empService.getCant());
		    asigna.inicial(totalPreins,totalEmpAses); 
		    
		    ModAsig asig[] = new ModAsig[asigna.asignados];		    
		    asig=asigna.asig;
		    ModAsig asig2[] = new ModAsig[asigna.asignados];		 
		    //String fecha=asigRepositorio.crearAsignacion(asig); 
		    //asig2=asigRepositorio.getAsigActual(asig2,fecha);
		    //Iterable<Asignacion> res = asigRepositorio.getAll();
		    return new ResponseEntity<ModAsig[]>  (asigna.asig, HttpStatus.OK);
		} catch (Exception e) {
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    
    }
}