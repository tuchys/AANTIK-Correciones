package com.aantik.demo.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.aantik.demo.cargaUsuarios.leerEstudiantes;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.model.ModEstudiante;
import com.aantik.demo.service.EstudianteCRUD;

@Controller
public class cargaEstControl {
	@Autowired
	EstudianteCRUD servEst;
	
	@GetMapping("/cargaMasSt")
	public ResponseEntity<Estudiante[]> sendCiiu() {
		Estudiante est[] = new Estudiante[2];
		try {
			ModEstudiante [] Stlista = new ModEstudiante[500];
			leerEstudiantes excelStu = new leerEstudiantes();
			FileInputStream fis2;
			int cantSt=0;
			try {

				fis2 = new FileInputStream(new File("resEncuesta.xlsx"));
				cantSt=excelStu.getInscritos(fis2,Stlista);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Actualizando "+cantSt+" datos");
				servEst.saveAll(Stlista,cantSt);
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
}
