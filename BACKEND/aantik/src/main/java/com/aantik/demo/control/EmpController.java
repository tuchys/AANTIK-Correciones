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
import com.aantik.demo.cargaUsuarios.leerEmprendimientos;
import com.aantik.demo.model.ModBench;
import com.aantik.demo.model.ModEmprendimiento;
import com.aantik.demo.model.ModelBenchAux;
import com.aantik.demo.model.encuestaPre;
import com.aantik.demo.repositorio.PreguntasRepository;
import com.aantik.demo.service.BenchmarkingExcelService;
import com.aantik.demo.service.DiagnosticoCRUD;
import com.aantik.demo.service.EmprendimientoCRUD;
import com.aantik.demo.service.PreguntaCRUD;
import com.aantik.demo.service.PreguntaExcelService;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController
public class EmpController {
	@Autowired
	EmprendimientoCRUD empService;

    @Autowired
    BenchmarkingExcelService BenfileService;
    
    @Autowired
    DiagnosticoCRUD dgvServ;
    
    @Autowired
    PreguntaCRUD pregServ;
	
    @PostMapping("/datosEmp")
    public ResponseEntity<?> processForgotPassword(@RequestBody encuestaPre update) {

    System.out.println("Tel: " + update.getTelefono());

    System.out.println("Localidad: " + update.getLocalidad());
    return ResponseEntity.ok("ok");
    }
    
    @GetMapping("/empCargaM")
	public ResponseEntity<ModEmprendimiento[]> cargaStu() {
		ModEmprendimiento est[] = new ModEmprendimiento[2];
		try {
			ModEmprendimiento [] empLista = new ModEmprendimiento[500];
			leerEmprendimientos excelEmp = new leerEmprendimientos();
			FileInputStream fis2;
			try {
				fis2 = new FileInputStream(new File("Datos basicos-formato.xlsx"));
				excelEmp.getEmprendimientos(fis2,empLista);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				empService.saveAll(empLista);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return new ResponseEntity<ModEmprendimiento[]>(est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/benchGet")
	public ResponseEntity<ModBench[]> generarBench() { 
	//public ResponseEntity<Mpreinscrito[],String>  sendStudents() {
		ModBench est[] = new ModBench[10];
		//System.out.println("estudiante: " + correo);
		try {
			int tamanio=BenfileService.cantidad();
			ModelBenchAux[] auxB = new ModelBenchAux[tamanio];
			auxB=BenfileService.getInfo(auxB);
			pregServ.getCodigoPreg(auxB,auxB.length);
			String aux=auxB[0].indicador;	
			int i=0,total=0,CP=0;
			est[0]=new ModBench();
			for(ModelBenchAux var: auxB) {
				System.out.println("preguntas que aplican"+var.codigo+var.indicador);
				if(aux.equals(var.indicador)) {
					total=total+dgvServ.getPuntaje(var.codigo);		
					est[i].nombre=var.indicador;
					est[i].puntaje=total;
					System.out.println(var.indicador+"--------"+total);			
					CP++;
					System.out.println("----CANTIDAD X INDICADOR----"+CP);										
				}else {	
					if(CP>1 && i>1) {
						float promedio = est[i-1].puntaje/CP;
						System.out.println("----anterior----"+est[i-1].puntaje+"-.----actual"+est[i].puntaje+"prom...."+promedio);		
					}else
						System.out.println("----promerio----"+total);		
					CP=1;
					i++;
					est[i]=new ModBench();
					aux=var.indicador;
					total=dgvServ.getPuntaje(var.codigo);
					System.out.println(var.indicador+"--------"+total);						
					est[i].nombre=var.indicador;
					est[i].puntaje=total;
				}
			}
			BenfileService.getDesc(est);
			System.out.println("RESULTADO......");
			for(int j=0;j<i;j++) {
				System.out.println(est[j].nombre+"----"+est[j].puntaje);
			}
						
			return new ResponseEntity<ModBench[]>  (est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
    
}
