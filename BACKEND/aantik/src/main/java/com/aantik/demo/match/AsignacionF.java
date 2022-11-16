package com.aantik.demo.match;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aantik.demo.entidad.Coordinador;
import com.aantik.demo.repositorio.CoordinadorRepositorio;
import java.util.Random;
import java.io.IOException;
import java.io.InputStream;

import com.aantik.demo.model.ModAsig;
import com.aantik.demo.model.ModEmprendimiento;
import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;

import com.aantik.demo.cargaUsuarios.leerEmprendimientos;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.model.ModEmprendimiento;
import com.aantik.demo.model.Mpreinscrito;
import com.aantik.demo.service.UserCRUD;


public class AsignacionF {

	int cantEst=100;
	int cantEmp=100;
	int asignados=0;
	public ModAsig asig[] = new ModAsig[20];
	int estu[][][]= new int[cantEst][cantEmp+1][2] ;
	int asignaciones[][]= new int[cantEst][2];
	int cupos[][] = new int[cantEmp][2];
	
	public void inicial() {
		Instancias ins=new Instancias();

		
		System.out.println(ins.preinscritos[0]);
		ins.instanciaEmprendimientos2();
		String fileEst="test.csv";
		ins.instanciaEstudiantes(fileEst);
		
		//Asignacion this= this.Class;
		this.calcularPuntaje(ins);
		this.llenar2(ins);
		this.imprimirD1();
		this.imprimirD2();
		this.llenarCupos();
		this.imprimirCupos();

		this.operacionInicial();
		System.out.println("----match inicial---");
		this.mathcInicial(ins);
		System.out.println("----resultado match inicial---");
		this.imprimirD2();
		System.out.println("----match recursivo---");
		this.mathc2();
		System.out.println("----resultado match---");
		this.imprimirD2();
		this.asignacion(ins);
		
	}
	
	static void respuesta(String command,Channel channel) throws IOException {
		



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
	  /*if(est.tipoOrg == emp.tipoOrg){
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
	
	void mathcInicial(Instancias in) {
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
				
			}
			if(estu[idEst][0][1]!=0) {
				asignaciones[asignados][0]=estu[idEst][0][1];		
				asignaciones[asignados][1]=idemp;
				ModEmprendimiento ret=new ModEmprendimiento(); 
				ret=in.getemp(asignaciones[asignados][1]);
				System.out.println("Asignado a estudiante "+asignaciones[asignados][0]+" el emprendimiento "+ret.nombreEmp+" "+ret.direccion+" "+ret.localidad);
				asignados++;
				estu[idEst][0][1]=0;
			}
			
			mayor=0;

			if(i>=cantEst) {
				break;
			}			
		}
	}
	
	void mathc2() {
		int mayor=0;
		int idEst=0;
		int idEmp=0;
		for(int i=0;i<cantEst;i++) {
			if(estu[i][0][1] != 0) {
				for(int j=1;j<cantEmp+1;j++) {
					boolean asig=this.asignado(estu[i][j][0]);
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
	
	void asignacion(Instancias in) {
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
			ModEmprendimiento ret=new ModEmprendimiento();
			ret=in.getemp(asignaciones[i][1]);
			String nombreStu = in.nomEst(asignaciones[i][0]);
			String correoStu = in.corEst(asignaciones[i][0]);
			System.out.println("Estudiante: "+asignaciones[i][0]+"\n"+nombreStu+
					"\n"+correoStu+
					"\n Asignado a emprendimiento "+asignaciones[i][1]+" "+ret.nombreEmp
					+"\nUbicado en direccion: "+ret.direccion+" y localidad: "
					+ret.localidad+"\n\n");
			asig[i]= new ModAsig();
			asig[i].id= asignaciones[i][0];
			asig[i].nombre= (nombreStu);
			asig[i].correo= (correoStu);
			asig[i].emprendimiento= (ret.nombreEmp);

		}
	}
	
}

	


