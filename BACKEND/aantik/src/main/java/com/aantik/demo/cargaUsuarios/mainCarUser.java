package com.aantik.demo.cargaUsuarios;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aantik.demo.model.ModDocente;
import com.aantik.demo.model.ModEmprendimiento;
import com.aantik.demo.model.ModEstudiante;
import com.aantik.demo.model.ModOrgSocial;
import com.aantik.demo.model.Mpreinscrito;

public class mainCarUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mpreinscrito [] preLista = new Mpreinscrito[500];
		ModEmprendimiento [] empLista = new ModEmprendimiento[500];
		ModOrgSocial [] orgLista = new ModOrgSocial[50];
		ModDocente [] docLista = new ModDocente[50];
		ModEstudiante [] estLista = new ModEstudiante[500];
		leerEstudiantes excelStu = new leerEstudiantes();
		leerEmprendimientos excelEmp = new leerEmprendimientos();
		leerEntidades excelOrg = new leerEntidades();
		leerDocentes excelDoc= new leerDocentes();
		FileInputStream fis2;
		
		try {
			fis2 = new FileInputStream(new File("preinscritos.xlsx"));
			//tejido.leerTejido(fis2,CIIUlista);
			excelStu.getPreinscritos(fis2,preLista);
			fis2 = new FileInputStream(new File("Datos basicos-formato.xlsx"));
			excelEmp.getEmprendimientos(fis2,empLista);
			fis2 = new FileInputStream(new File("resEncuesta.xlsx"));
			int cantSt=excelStu.getInscritos(fis2,estLista);
			
			fis2 = new FileInputStream(new File("Datos basicos-formato.xlsx"));			
			excelOrg.getEntidades(fis2,orgLista);
			
			fis2 = new FileInputStream(new File("Datos basicos-formato.xlsx"));			
			int cant=excelDoc.getDocente(fis2,docLista);
			System.out.println(cant);
			//fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
		//	tejido.getActividad(fis2,preLista,cant);
			System.out.println("cantidad clase: "+cantSt);
			System.out.println(preLista[10].nombre);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
