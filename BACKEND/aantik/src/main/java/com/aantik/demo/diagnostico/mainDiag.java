package com.aantik.demo.diagnostico;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.aantik.demo.model.ModInfoPregunta;
import com.aantik.demo.model.ModeloPregunta;
import com.aantik.demo.model.convenciones;

public class mainDiag {

	@SuppressWarnings("null")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		convenciones conven = new convenciones();
		ModInfoPregunta infoPreg[] =new ModInfoPregunta[200] ;
		leerDiagnostico DGV = new leerDiagnostico();
		FileInputStream fis2;
		ModeloPregunta preguntas[]= new ModeloPregunta[200];
		int cant = 0,cant2=0,cant3=0,cant4=0,cant5=0;
		try {
			fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
			cant=DGV.leerConvenciones(fis2,conven);
			System.out.println("cantidad datos= "+conven.AreaFuncional[0].id);
			System.out.println("cantidad datos= "+cant);
			System.out.println("AREA FUNCIONAL");
			for (int i=0;i<cant;i++) {
				if(conven.AreaFuncional[i].titulo!=null) {
					System.out.println(conven.AreaFuncional[i].id+" "+conven.AreaFuncional[i].titulo);
				}
			}
			System.out.println("CARGO QUE DEBERIA RESPONDER");
			for (int i=0;i<cant;i++) {
				if(conven.CargoResp[i].titulo!=null) {
					System.out.println(conven.CargoResp[i].id+" "+conven.CargoResp[i].titulo);
				}
			}
			System.out.println("VARIABLE ORGANIZACIONAL");
			for (int i=0;i<cant;i++) {
				if(conven.VarOrga[i].titulo!=null) {
					System.out.println(conven.VarOrga[i].id+" "+conven.VarOrga[i].titulo);
				}
			}
			System.out.println("NIVEL SCOR");
			for (int i=0;i<cant;i++) {
				if(conven.NivelScor[i].titulo!=null) {
					System.out.println(conven.NivelScor[i].id+" "+conven.NivelScor[i].titulo);
				}
			}
			fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
			cant=DGV.leerInfoPreg(fis2,infoPreg);
			System.out.println(".---"+cant);
			System.out.println(infoPreg[1].pregunta+".---"+cant);

			fis2 = new FileInputStream(new File("DGV3 OCTUBRE 2022.xlsx"));
			cant3=DGV.leerPregLP(fis2,preguntas);
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
			System.out.println(preguntas[2].rub[1].cuanti+" "+preguntas[2].automatica+preguntas[2].rub[1].rubrica);
			System.out.println(preguntas[1].rub[2].cuanti+" "+preguntas[1].automatica);
			System.out.println(preguntas[79].rub[1].cuanti+" "+preguntas[79].pregunta+preguntas[79].rub[1].rubrica);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
