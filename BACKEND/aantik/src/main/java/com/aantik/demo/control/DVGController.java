package com.aantik.demo.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.aantik.demo.entidad.Preguntas_Dig;
import com.aantik.demo.entidad.Rubrica_preg_dg;
import com.aantik.demo.model.ModDGRes;
import com.aantik.demo.model.ModDGV;
import com.aantik.demo.model.ModRubrica;
import com.aantik.demo.model.ModeloPregunta;
import com.aantik.demo.service.DiagnosticoCRUD;
import com.aantik.demo.service.PreguntaCRUD;

@Controller
public class DVGController {
	
	@Autowired
	PreguntaCRUD servPreg;
	@Autowired
	DiagnosticoCRUD servDG;
	
	@GetMapping("/dgvGet")
	public ResponseEntity<ModeloPregunta[]> sendStudents() { 
	//public ResponseEntity<Mpreinscrito[],String>  sendStudents() {
		Iterable<Preguntas_Dig> est = null;
		int cantidad=servPreg.getCantidad();
		ModeloPregunta[] est2=new ModeloPregunta[cantidad];
		try {
			est= servPreg.getAll();
			int i=0;
			for (Preguntas_Dig estA : est){
				est2[i]=new ModeloPregunta();
				est2[i].codigo=estA.getCodigo();
				est2[i].pregunta=estA.getPregunta();
				est2[i].insump=estA.getInsump();
				est2[i].automatica=Boolean.parseBoolean(estA.getAutomatica());
				int canR=servPreg.getCantidadRubrica(estA.getId());
				int j=0;
				est2[i].rub=new ModRubrica[canR];
				Iterable<Rubrica_preg_dg> rub=servPreg.getRubrica(estA.getId());
				for(Rubrica_preg_dg var: rub) {
					est2[i].rub[j]=new ModRubrica();
					est2[i].rub[j].cuanti=var.getCuanti();
					est2[i].rub[j].rubrica=var.getRubrica();
					est2[i].rub[j].actividad=var.getActividad();
					est2[i].rub[j].codigoP=estA.getCodigo();
					System.out.println(j+"---"+est2[i].rub[j].cuanti);
					j++;
				}
				i++;
				System.out.println(estA.getPregunta());
			}
			System.out.println(cantidad);
			return new ResponseEntity<ModeloPregunta[]>  (est2, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	 @PostMapping("/saveDGV")
	public ResponseEntity<?> processForgotPassword(@RequestBody ModDGV dgvRespuestas) {
		 if(dgvRespuestas.puntajeS != null) {
		    System.out.println("dgv string: " + dgvRespuestas.puntajeS);
		    System.out.println("dgv string: " + dgvRespuestas.codigo);
		    System.out.println("dgv string: " + dgvRespuestas.correo);
		    try {
				servDG.crearDiagnostico(dgvRespuestas);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		 }else if(dgvRespuestas.puntajeN != 0) {
			System.out.println("dgv string: " + dgvRespuestas.puntajeN);
		    System.out.println("dgv string: " + dgvRespuestas.codigo);
		    System.out.println("dgv string: " + dgvRespuestas.correo);	
			 try {
				servDG.crearDiagnostico(dgvRespuestas);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	     
		 }
	    return ResponseEntity.ok("ok");	    
	 }
	    
		@PostMapping("/getResDG")
		public ResponseEntity<ModDGRes[]> diagnosticoResp( @RequestParam String correo) {
	        System.out.println(correo);
	        int tam=servDG.getTamanio(correo);
			ModDGRes[] resp=new ModDGRes[tam];
			resp=servDG.getResXuser(resp,correo);
			
			System.out.println("estudiante: " + correo);
			/*for(int i =0;i<8;i++)
				resp[i]=new ModDGRes();
		    */return new ResponseEntity<ModDGRes[]>(resp, HttpStatus.OK);
		}
}
