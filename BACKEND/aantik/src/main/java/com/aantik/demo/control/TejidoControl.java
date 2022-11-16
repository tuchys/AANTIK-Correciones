package com.aantik.demo.control;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.aantik.demo.entidad.CIIU;
import com.aantik.demo.entidad.RedTejido;
import com.aantik.demo.entidad.Ciiu_Emp;
import com.aantik.demo.entidad.Emprendimiento;
import com.aantik.demo.entidad.OrgSocial;
import com.aantik.demo.model.tejidoSocial;
import com.aantik.demo.repositorio.EmprendimientoRepositorio;
import com.aantik.demo.model.ModCiiuXemp;
import com.aantik.demo.model.ModRedTejido;
import com.aantik.demo.service.CiiuCRUD;
import com.aantik.demo.service.EmprendimientoCRUD;
import com.aantik.demo.service.OrgSocialCRUD;
import com.aantik.demo.service.TejidoCRUD;
import com.aantik.demo.tejido.leerExcelTejido;
import com.aantik.demo.tejido.tejidoServicio;

@Controller
public class TejidoControl {
	@Autowired
	CiiuCRUD servCiiu;
	@Autowired
	TejidoCRUD servRed;
	@Autowired
	EmprendimientoCRUD servEmp;
	@Autowired
	OrgSocialCRUD servOS;
	@Autowired
	EmprendimientoRepositorio repository;
	
	@GetMapping("/cargaCIIU")
	public ResponseEntity<CIIU[]> sendCiiu() {
		CIIU est[] = new CIIU[2];
		try {
			com.aantik.demo.model.CIIU [] CIIUlista = new com.aantik.demo.model.CIIU[500];
			tejidoSocial [] redTejido = new tejidoSocial[2000];
			leerExcelTejido tejido = new leerExcelTejido();
			ModCiiuXemp[] cruzar=new ModCiiuXemp[500];
			FileInputStream fis2;
			int cant=0,cantRed=0,cant2 = 0;
			try {
				fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
				cant=tejido.getDatosCiiu(fis2,CIIUlista);
				fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
				tejido.getActividad(fis2,CIIUlista,cant);
				fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
				cantRed=tejido.leerTejido(fis2,redTejido);
				fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
				cant2=tejido.getCuzeInf(fis2,cruzar);
				System.out.println(cant2);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				System.out.println("Actualizando "+cant+" datos cod CIIU");
				servCiiu.saveAll(CIIUlista,cant);
				System.out.println("Actualizando "+cant+" datos cod CIIU por emprendimineto");
				servCiiu.saveAll2(cruzar,cant2);
				System.out.println("Actualizando "+cantRed+" red tejido por codigos CIIU");
				servRed.saveAll(redTejido,cantRed);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				return new ResponseEntity<CIIU[]>(est, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	

	@GetMapping("/generaRed")
	public ResponseEntity<ModRedTejido> hacerTejido() {
		ModRedTejido red = new ModRedTejido();
		try {
			Iterable<RedTejido> redTejido;
			Iterable<Ciiu_Emp> cruzar;
			Iterable<Emprendimiento> empL;
			Iterable<OrgSocial> osL;
			//getall de ciiu emp
			cruzar=servCiiu.getAllCE();
			//getall de tejido social
			redTejido=servRed.getAll();
			empL=servEmp.getAll();
			osL=servOS.getAll();
			tejidoServicio ts= new tejidoServicio();
			Ciiu_Emp buscar = new Ciiu_Emp();
			buscar.setIdName("Prodesa");
			buscar.setIdCiiu((long)3830);
			red=ts.hacerTejido(buscar,redTejido,cruzar,empL,osL);
			red.raiz.nombre="Prodesa";
			return new ResponseEntity<ModRedTejido>(red, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Usuario no existe"+e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
}
