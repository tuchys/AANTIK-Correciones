package com.aantik.demo.match;

import com.aantik.demo.model.ModEmprendimiento;

public class InstanciasBD {
	public EstudianteM []estudiantes;//=new EstudianteM[40];
	public ModEmprendimiento []emprendimientos2;//=new ModEmprendimiento[50];

	/*
	void instanciaEstudiantes(String direccion) {
		lectura.leerEstudiantes(estudiantes,direccion);		
		System.out.println(estudiantes[0].disponibilidad);
	}

	void instanciaEmprendimientos2() {
		try {
			fis2= new FileInputStream(new File("Datos basicos-formato.xlsx"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		excelEmp.getEmprendimientos(fis2,emprendimientos2);		 
		System.out.println(emprendimientos2[0].actividadEco);
	}
	
	public void instanciaPreinscritos(String direccion) {
		lectura.leerPreinscritos(preinscritos,direccion);		 
		System.out.println(preinscritos[0].nombre);
	}*/
	
	int getCantEst() {
		int cantidad=0;
		for(int i=0;i<estudiantes.length;i++) {
			if(estudiantes[i]!=null) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	int getCantEmp() {
		int cantidad=0;
		for(int i=0;i<emprendimientos2.length;i++) {
			if(emprendimientos2[i]!=null) {
				cantidad++;
			}
		}
		return cantidad;
	}
	
	public ModEmprendimiento getemp(int id) {
		ModEmprendimiento ret=new ModEmprendimiento();
		for(int i=0;i<getCantEmp();i++) {
			if(emprendimientos2[i].id==id) {
				ret.nombreEmp=emprendimientos2[i].nombreEmp;
				ret.direccion=emprendimientos2[i].direccion;
				ret.localidad=emprendimientos2[i].localidad;
			}
		}
		return ret;
	}
	
	public String nomEst(int id) {
		String nombre=null;
		for(int i=0;i<getCantEst();i++) {
			if(estudiantes[i].id==id) {
				nombre=estudiantes[i].nombre;
			}
		}
		return nombre;
	}
	
	public String corEst(int id) {
		String correo=null;
		for(int i=0;i<getCantEst();i++) {
			if(estudiantes[i].id==id) {
				correo=estudiantes[i].correo;
			}
		}
		return correo;
	}
}
