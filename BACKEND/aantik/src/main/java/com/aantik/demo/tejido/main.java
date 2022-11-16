package com.aantik.demo.tejido;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.aantik.demo.model.CIIU;
import com.aantik.demo.model.ModCiiuXemp;
import com.aantik.demo.model.tejidoSocial;

public class main {

		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*leerExcel excel = new leerExcel();
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File("Preinscritos.xlsx"));
			excel.excelToTutorials(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  */
	//	MATRIZ ACTIVIDADES RELACIONES P

		tejidoSocial [] redTejido = new tejidoSocial[2000];
		leerExcelTejido tejido1 = new leerExcelTejido();
		FileInputStream fis2;
		int cant = 0;
		try {
			fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
			cant=tejido1.leerTejido(fis2,redTejido);
			System.out.println("cantidad datos= "+redTejido[cant-1].emprenDest);
			System.out.println("cantidad datos= "+cant);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CIIU [] CIIUlista = new CIIU[500];
		leerExcelTejido tejido = new leerExcelTejido();
		ModCiiuXemp[] cruzar=new ModCiiuXemp[500];
		//FileInputStream fis2;
		int cant2=0;
		try {
			fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
			//tejido.leerTejido(fis2,CIIUlista);
			int cant3=tejido.getDatosCiiu(fis2,CIIUlista);
			fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
			tejido.getActividad(fis2,CIIUlista,cant3);
			fis2 = new FileInputStream(new File("Enfasis   Cadena de Suministro.xlsx"));
			cant2=tejido.getCuzeInf(fis2,cruzar);
			System.out.println(cant2);
			tejidoServicio ts= new tejidoServicio();
			ModCiiuXemp buscar = new ModCiiuXemp();
			buscar.nombreEmp="Prodesa";
			buscar.idCiiu=(long)3830;
		//	ts.hacerTejidoTest(buscar,redTejido,cant,cruzar,cant2);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("CIU dato: "+CIIUlista[13].actividad+"-"+CIIUlista[13].agrupacion+"-"+CIIUlista[13].descripcion);
	}

}
