package com.aantik.demo.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.aantik.demo.diagnostico.leerDiagnostico;
import com.aantik.demo.entidad.CIIU;
import com.aantik.demo.model.ModCiiuXemp;
import com.aantik.demo.model.ModInfoPregunta;
import com.aantik.demo.model.ModeloPregunta;
import com.aantik.demo.model.convenciones;
import com.aantik.demo.model.tejidoSocial;
import com.aantik.demo.service.PreguntaCRUD;
import com.aantik.demo.tejido.leerExcelTejido;

@Controller
public class PregutnasController {
	
	@Autowired
	PreguntaCRUD servPreg;
	
	@GetMapping("/preguntasCarga")
	public ResponseEntity<String> sendCiiu() {
		String est = "NO OK";
		try {
			convenciones conven = new convenciones();
			ModInfoPregunta infoPreg[] = new ModInfoPregunta[200];
			leerDiagnostico DGV = new leerDiagnostico();
			FileInputStream fis2;
			ModeloPregunta preguntas[]= new ModeloPregunta[200];
			int cant = 0,cant2=0,cant3=0,cant4=0,cant5=0;
			try {
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant=DGV.leerConvenciones(fis2,conven);
				
				//CONVENCIONES
				
				servPreg.saveConvenciones(conven,cant);
				
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant3=DGV.leerPregLP(fis2,preguntas);
				System.out.println("--------"+cant3);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant4=DGV.leerPregCP(fis2,preguntas,cant3);
				System.out.println("--------"+cant4);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregPC(fis2,preguntas,cant4);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregQ(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregAbas(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregM(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregCD(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregGC(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregFCF(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregSI(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregCO(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregGT(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregSegI(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant5=DGV.leerPregP(fis2,preguntas,cant5);
				System.out.println("--------"+cant5);
				System.out.println("Actualizando "+cant5+" datos cod CIIU");
				cant5++;
				servPreg.saveAll(preguntas,cant5);
				
				//INFORMACION PREGUNTA
				fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
				cant=DGV.leerInfoPreg(fis2,infoPreg);
				servPreg.saveInfoPreg(infoPreg);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			return new ResponseEntity<String>(est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
