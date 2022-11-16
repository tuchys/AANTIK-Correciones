package com.aantik.demo.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.aantik.demo.model.ModAsignacion;
import com.aantik.demo.model.tejidoSocial;
import com.aantik.demo.tejido.leerExcelTejido;

@Controller
public class signacionControl {
	
		/*@Autowired
		CiiuCRUD servCiiu;
		@Autowired
		TejidoCRUD servRed;*/
		
		@GetMapping("/newAsign")
		public ResponseEntity<ModAsignacion[]> senAsig() {
			ModAsignacion asig[] = new ModAsignacion[212];
			try {
				com.aantik.demo.model.CIIU [] CIIUlista = new com.aantik.demo.model.CIIU[500];
				tejidoSocial [] redTejido = new tejidoSocial[2000];
				leerExcelTejido tejido = new leerExcelTejido();
				FileInputStream fis2;
				int cant=0,cantRed=0;
				try {
					fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
					cant=tejido.getDatosCiiu(fis2,CIIUlista);
					fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
					tejido.getActividad(fis2,CIIUlista,cant);
					fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
					cantRed=tejido.leerTejido(fis2,redTejido);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					System.out.println("Actualizando "+cant+" datos");
				//	servCiiu.saveAll(CIIUlista,cant);
					System.out.println("Actualizando "+cantRed+" red tejido");
				//	servRed.saveAll(redTejido,cantRed);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
					return new ResponseEntity<ModAsignacion[]>(asig, HttpStatus.OK);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("Usuario no existe"+e);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
			}
		}
		
}
