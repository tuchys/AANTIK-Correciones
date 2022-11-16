package com.aantik.demo.match;
import java.util.Stack;

import com.aantik.demo.model.ModEmprendimiento;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;

import java.util.Random;

public class jmain {
	//se obtienen de leer las tablas
	int cantEst=100;
	int cantEmp=100;
	int cantProf=10;
	int asignados=0;
	int estu[][][]= new int[cantEst][cantEmp+1][2] ;
	int asignaciones[][]= new int[cantEst][2];
	int cupos[][] = new int[cantEmp][2];
	int numxclase = 2;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Instancias ins=new Instancias();
		ins.instanciaEmprendimientos2();
		 String fileEst="test.csv";
		ins.instanciaEstudiantes(fileEst);
		
		jmain mt=new jmain();
		mt.calcularPuntaje(ins);
		mt.llenar2(ins);
		mt.imprimirD1();
		mt.imprimirD2();
		mt.llenarCupos();
		mt.imprimirCupos();

		mt.operacionInicial();
		System.out.println("----match inicial---");
		mt.matchdef();
		//mt.mathcInicial();
		//System.out.println("----resultado match inicial---");
		//mt.imprimirD2();
		//System.out.println("----match recursivo---");
		//mt.mathc2();
		//System.out.println("----resultado match---");
		//mt.imprimirD2();
		mt.asignacion();
		mt.reporteAsig(); //IdEstudiante	IdEmprendimiento nom	cel	correo	nom emp	nom int	cel int	correo int	profe	num cla
		mt.distribucion();
		
	}
	
	void calcularPuntaje(Instancias in) {
		cantEst=in.getCantEst();
		System.out.println("----Cantidad de estudiantes "+this.cantEst+"---");
		cantEmp=in.getCantEmp();
		System.out.println("----Cantidad de emprendimientos "+this.cantEmp+"---");
		
		
	}
	
	void llenar2(Instancias in) {
		for(int i =0;i<cantEst;i++) {
			estu[i][0][0]=in.estudiantes[i].id;			
			estu[i][0][1]=estu[i][0][0];
		}
		for(int j =1;j<cantEmp+1;j++) {
			//estu[0][j][0]=new Random().nextInt(30)+11;
			estu[0][j][0]=in.emprendimientos2[j-1].id;
			cupos[j-1][0]=estu[0][j][0];
		}
		//puntajes 
		for(int i = 0;i<cantEst;i++) {
			for(int j =1;j<cantEmp+1;j++) {
				estu[i][j][1]=this.match(in.estudiantes[i], in.emprendimientos2[j-1]);
				estu[i][j][0]=estu[0][j][0];
			}
		}
	}
	
	void llenar() { 
		//generar ids random
		for(int i =0;i<cantEst;i++) {
			estu[i][0][0]=i+1;			
			estu[i][0][1]=estu[i][0][0];
		}
		for(int j =1;j<cantEmp+1;j++) {
			//estu[0][j][0]=new Random().nextInt(30)+11;
			estu[0][j][0]=cantEst+1+j;
			cupos[j-1][0]=estu[0][j][0];
		}
		//puntajes 
		for(int i = 0;i<cantEst;i++) {
			for(int j =1;j<cantEmp+1;j++) {
				estu[i][j][1]=new Random().nextInt(30)+31;
				estu[i][j][0]=estu[0][j][0];
			}
		}
	}

	void imprimirD1() {
		System.out.println("id estudiante| id emprendimiento");
		for(int i = 0;i<cantEst;i++) {
			for(int j =0;j<cantEmp+1;j++) {
				System.out.print(estu[i][j][0]+" | ");			
			}
			System.out.println("");
		}
	}
	
	void imprimirD2() {
		System.out.println("id estudiante|  puntaje emprendimiento");
		for(int i = 0;i<cantEst;i++) {
			for(int j =0;j<cantEmp+1;j++) {
				System.out.print(estu[i][j][1]+" | ");			
			}
			System.out.println("");
		}
	}
	
	void imprimirCupos() {
		System.out.println("id entidad | cupos");
		for(int j =0;j<cantEmp;j++) {
			System.out.println(cupos[j][0]+" | "+cupos[j][1]);			
		}
		System.out.println("");
	}
	
	void llenarCupos() {
		for(int j =0;j<cantEmp;j++) {
			cupos[j][1]=new Random().nextInt(3)+1;
		}
	}
	
	boolean dispo(EstudianteM est, ModEmprendimiento emp){
	  String es;
	  String em;
	  es= est.disponibilidad;
	  em = emp.disponibilidad;
	  for(int i = 0; i < es.length(); i=i+4){
	    for(int j = 0; j < em.length(); j=j+4){//sacar sub string de 3 char
	      if(es.equals(em) ){
	        return true;
	        }
	    }
	  }
	  return false;
	}

	int match(EstudianteM est, ModEmprendimiento emp){
	  int val = 0;
	  if(est.genero != emp.genero && emp.genero != 'I'){
	    return -999;
	  }else if(est.limitacion==true && emp.limitacion==false){
	    return val-999;
	  }
	  if(est.localidad == emp.localidad){
	    val += est.pUbicacion*2;
	  }
	  if(est.transporte==true){
	    val += -2;
	  }
	  if(est.actividadExtra==true){
	    val += 2;
	  }
	  if(dispo(est, emp)){
	    val += 4;
	  }
	 /* if(est.tipoOrg == emp.tipoOrg){
	    val += est.pTipoOrg;
	  }
	  if(est.tipoEmp == emp.tipoEmp){
	    val += est.pTipoOrg;
	  }*/
	  if(est.actividadEco == emp.actividadEco){
	    val += est.pActividad;  
	  }
	  if(est.comunidad == emp.comunidad){
	    val += est.pComunidad;
	  }/*
	  if(enfasis(est.enfasis, emp.actividadEco)){
	    val += 2;
	  }*/
	  if(est.modalidad == emp.modalidad){
	    val += 2;
	  }
	  if(est.experiencia == emp.experiencia && est.experiencia == true){
	    val += 5;
	  }
	  if(est.promedio == true && emp.promedio == true){
	    val += 3;
	  }
	  if(est.contacto==emp.contacto){
	    val += 1;
	  }
	  /*if(est.limitLocalidad.equals(emp.localidad)){
	    val += - est.pUbicacion*2;
	  }*/
	  return val;		   
	}
	/*
	void mathcInicial() {
		int mayor=0;
		int idEst=0;
		int idemp=0;
		for(int i=1;i<cantEmp+1;i++) {
			for(int j=0;j<cantEst;j++) {
				if((estu[j][i][1]>mayor)&(estu[j][0][1]!=0)) {
					mayor=estu[j][i][1];
					idEst=j;
					idemp=estu[j][i][0];
										
				}
				
			}/*me vo a matar wee

		        int ii, first, second, third; 
		        int id1 = -1, id2 = -1, id3 =-1;
		 

		 
		        third = first = second = Integer.MIN_VALUE;
		        for (ii = 0; ii < cantEst; ii++) {

		            if (estu[ii][i][1] > first) {
		                third = second;
		                id3=id2;
		                second = first;
		                id2=id1;
		                first = estu[ii][i][1];
		                id1=ii;
		            }

		            else if (estu[ii][i][1] > second) {
		                third = second;
		                id3=id2;
		                second = estu[ii][i][1];
		                id2=ii;
		            }
		 
		            else if (estu[ii][i][1] > third)
		                third = estu[ii][i][1];
		            	id3=ii;
		        }
		        int aux[] = {id1,id2,id3};
		 
		    
			/*me vo a matar wee
			for(int n = 0; n < cupos[i][1]; n++) {
				
				if(estu[aux[n]][0][1]!=0) {
					asignaciones[asignados][0]=estu[aux[n]][0][1];
				//if(estu[idEst][0][1]!=0) {
					//asignaciones[asignados][0]=estu[idEst][0][1];
					asignaciones[asignados][1]=idemp;
					System.out.println("Asignado a estudiante "+asignaciones[asignados][0]+" el emprendimiento "+asignaciones[asignados][1]);
					asignados++;
					estu[aux[n]][0][1]=0;
					//estu[idEst][0][1]=0;
					
				}




				
			}
			
			mayor=0;

			if(i>=cantEst) {
				break;
			}			
		}
	}*/
	/*
	void mathc2() {
		int mayor=0;
		int idEst=0;
		int idEmp=0;
		for(int i=0;i<cantEst;i++) {
			if(estu[i][0][1] != 0) {
				for(int j=1;j<cantEmp+1;j++) {
					**********boolean asig=this.asignado(estu[i][j][0]);
					if((estu[i][j][1]>mayor)&(estu[i][0][1]!=0)&(asig==true)) {
						mayor=estu[i][j][1];
						idEst=i;
						idEmp=estu[i][j][0];	
					}		
				}
				if(mayor!=0) {
					asignaciones[asignados][0]=estu[idEst][0][1];		
					asignaciones[asignados][1]=idEmp;
					System.out.println("Asignado a estudiante "+asignaciones[asignados][0]+" el emprendimiento "+asignaciones[asignados][1]);
					asignados++;
					estu[i][0][1]=0;
					mayor=0;
				}
				
			}			
		}
	}*/
	
	void matchdef(){
		
		while(asignados < cantEst) {

			int max=0;
			int max2=0;
			int idEst = -1;
			int posEst = -1;
			int idEmp= -1;
			int posEmp = -1;
			int val= -1;

			boolean esta=true;
			Stack<Integer> empUsados = new Stack<Integer>();
			System.out.println(" | ");
				
			
			for(int i = 0;i<cantEst;i++) {
				//System.out.println(estu[i][0][1]);
				for(int j =1;j<cantEmp+1;j++) {
					//System.out.println(estu[i][j][1]+" | ");
					boolean asig=this.asignado(estu[i][j][0]);
					if(max < estu[i][j][1] && estu[i][0][1] != 0 && asig) {
						max = estu[i][j][1];
						idEst = estu[i][0][1];
						idEmp = estu[i][j][0];
						val = estu[i][j][1];
						posEmp = j;
						posEst = i;
						
					}
				}

				
				
			} 
			if(estu[posEst][0][1] != 0) {
				asignaciones[asignados][0]=estu[posEst][0][0];		
				asignaciones[asignados][1]=idEmp;
				estu[posEst][0][1]=0;
				System.out.println("Asignado a estudiante "+asignaciones[asignados][0]+" el emprendimiento "+asignaciones[asignados][1]);
				asignados++;
				empUsados.add(idEmp);
				
			}
		
			

			for(int i = 1; i < cupos[posEmp-1][1]; i++) {
				for(int j =0;j<cantEst;j++) {
					if(max2 < estu[j][posEmp][1]&& estu[j][0][1] != 0) {
						max2 = estu[j][posEmp][1];
						posEst = j;
					}

				}
				if(estu[posEst][0][1] != 0) {
					asignaciones[asignados][0]=estu[posEst][0][1];		
					asignaciones[asignados][1]=idEmp;
					estu[posEst][0][1]=0;
					System.out.println("Asignado a estudiante "+asignaciones[asignados][0]+" el emprendimiento "+asignaciones[asignados][1]);
					asignados++;
					max2=0;
				}
				
			}
			
			
		}
				
			
		
	}

	
	boolean asignado(int idEmp) {

		//System.out.println("Validando cupos en "+idEmp);
		int cuposDis=0;
		for(int i=0;i<asignados;i++) {
			if(asignaciones[i][1]==idEmp) {
				cuposDis++;				
			}			
		}
		//System.out.println("cupos asignados"+cuposDis);
		for(int j=0; j<cantEmp;j++) {
			if(cupos[j][0]==idEmp) {
				if(cupos[j][1]>cuposDis) {
					return true;
				}else
					return false;
			}			
		}		
		return false;
	}
	
	boolean validarAsigEst() {
		for(int i=0;i<cantEst;i++) {
			if(estu[i][0][1] != 0) {
				return false;
			}			
		}
		return true;
	}
	
	void operacionInicial() {
		int cuposTotales=0;
		for(int i=0;i<cantEmp;i++) {
				cuposTotales=cuposTotales+cupos[i][1];						
		}
		if(cuposTotales>cantEst) 
			System.out.println("hay mas cupos que estudiantes");
		else if(cuposTotales<cantEst) 
			System.out.println("hay mas estudiantes que cupos en las entidades, quedaran alumnos sin asignacion");	
		if(cantEmp>cantEst) 
			System.out.println("hay mas emprendimientos que estudiantes, sobran emprendimientos");
		/*else if(cantEmp<cantEst) 
			System.out.println("hay mas estudiantes que emprendimientos, quedarán estudiantes sin asignación");
		*/if(cuposTotales==cantEst)
			System.out.println("Cantidad de cupos igual a cantidad de estusdiantes, condiciones optimas de asignación");
		
	}
	
	void asignacion() {
		int cuposTotales=0;
		int cuposAsignados=0;
		System.out.println("----RESULTADOS DE ASIGNACIÓN----");	
		for(int i=0;i<cantEmp;i++) {
			cuposTotales=cuposTotales+cupos[i][1];						
		}
		
		System.out.println("-Cupos totales- "+cuposTotales+" -Asignaciones- "+asignados);	
		
		if(cantEmp>cantEst) {
			System.out.println("-Emprendimientos sin asignar-");
			boolean find=true;
			for(int i=0;i<cantEmp+1;i++) {
				int idEmpr=estu[0][i][0];
				for(int j=0;j<asignados;j++) {
					if(idEmpr==asignaciones[j][1]) 
						find=true;
				}
				if(find==false) {
					System.out.println(idEmpr);					
				}
				find=false;
			}				
		}	
		
		if(asignados<cantEst) {
			System.out.println("-Estudiantes sin asignar-");
			for(int i=0;i<cantEst;i++) {
				if(estu[i][0][1]!=0)
					System.out.println(estu[i][0][1]);
			}
		}
		System.out.println("-Asignaciones realizadas-");
		for(int i=0;i<asignados;i++) {
			System.out.println("Estudiante: "+asignaciones[i][0]+" Asignado a emprendimiento "+asignaciones[i][1]);
		}
	}
	
	void reporteAsig() {
	    try {
	        FileWriter csv = new FileWriter("reporteAsignacionEstudiantes.csv");
	        csv.write("IdEstudiante" + "," + "IdEmprendimiento" + "\r\n");  
	        for(int i = 0; i < cantEst; i++) {
	        	csv.write(asignaciones[i][0] + "," + asignaciones[i][1] + "\r\n");
	        }
	        csv.close();
	        System.out.println("Reporte de asignacion escrito.");
	      } catch (IOException e) {
	        System.out.println("Error en reportes de asignacion.");
	        e.printStackTrace();
	      }
		
	}


 
	
	

	
	void distribucion() {
		
		float planta = 0;//profPlanta();
		float aux = 0;
		float otro = 0;
		float menos=0;
		int numclases = -1;
		int profesores = 0;
		int ac=0;
		String[][] prof = {{"juan", "planta"},{"loki", "otro"},{"jesus", "planta"},{"dios", "otro"},{"venito", "planta"},{"camelas", "planta"},{"rosa", "planta"}};
		for (int i = 0; i < prof.length; i++) {
			if (prof[i][1] == "planta")
				planta++;			
		}
		profesores = prof.length;

		aux = planta + otro;


		if(cantEst/aux < numxclase) {
			while(cantEst/aux < numxclase) {
				otro--;
				aux = planta + otro;
			}
		}


		if(cantEst/aux > numxclase) {
			
			while(cantEst/aux > numxclase) {
				otro++;
				aux = planta + otro;
			}
				
		}
		int asig=0;
		try {
	        FileWriter csv2 = new FileWriter("reporteAsignacionProfesores.csv");
	        csv2.write("Nombre" + "," + "Cargo" + "," + "Curso" +"\r\n");  
	        for(int i=0; i < profesores; i++) {
				if(prof[i][1] == "planta") {//contrato
					csv2.write(prof[i][0] + "," + "planta" + "," + asig +"\r\n");
					System.out.println("Profesor de planta " + prof[i][0] + " asignado");//nombre
					asig++;
					if(asig > aux)
						break;
				}
			}

	        	
				if(otro > 0) {					
					for(int i=0; i < profesores; i++) {
						if(prof[i][1] == "otro") {
							csv2.write(prof[i][0] + "," + "otro" + "," + asig +"\r\n");
							System.out.println("Profesor de contrato " + prof[i][0] + " asignado");
							asig++;
							if(asig > aux)
								break;
						}
					
											
				}
			}
	        	
	        	
	        csv2.close();
	        System.out.println("Reporte de asignacion escrito.");
	      } catch (IOException e) {
	        System.out.println("Error en reportes de asignacion.");
	        e.printStackTrace();
	      }


		

		System.out.println("Numero de profesor de planta " + Math.round(planta - menos) + " asignados");
		if(otro > 0)
		System.out.println("Numero de profesor de contrato " + Math.round(otro) + " asignados");

		
	}
	void filtro() {
		
	}
	
}
