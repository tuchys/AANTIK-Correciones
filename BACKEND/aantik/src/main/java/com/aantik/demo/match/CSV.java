package com.aantik.demo.match;

import java.io.*;

import com.aantik.demo.model.Mpreinscrito;
public class CSV {
	
	/* public static void main(String[] args) {
	  
	  //CSV = Comma-Separated Values 
	  //   text file that uses a comma to separate values
		  
		  String file = "test.csv";
		  BufferedReader reader = null;
		  String line = "";
		  int numLineas = 0;
		  int numPreguntas = 0;
		
		  String[] Arr = new String[195];
		  String[][] Mat = new String[5][40];
		  
		  try {
		   reader = new BufferedReader(new FileReader(file));
		   reader.readLine();
		   while((line = reader.readLine()) != null) {
		
		    
		    String[] row = line.split(",");
		    
		    for(String index : row) {
		    
		     System.out.printf("%-10s", index);
		     index = index.replaceAll("\"", "");
		     Arr[numPreguntas] = (String)index;
			 numPreguntas++;
		    }
		    System.out.println();
		    numLineas++;
		   }
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
		  System.out.println("Numero de lineas: " + numLineas);
		  System.out.println("Numero de preguntas: " + numPreguntas/numLineas);
		  System.out.println("Numero de datos: " + numPreguntas);
		 /* for(int i=0;i<Arr.length;i++)
		  {
		      System.out.println(Arr[i]);
		  }*/
	/*	  int k =0;
		  for(int i = 0; i < 5; i++){
			  System.out.println("--------------------------------------------------");
			     for(int j = 0; j < 39; j++){
			         Mat[i][j] =  Arr[k] ;
			         k++;
			         System.out.println(Mat[i][j]);
			     }
		 }
		  //modificar disponibilidad
		 
		  for(int i = 0; i < 5; i++){
			  int f=0;
		  System.out.println(Mat[i][24]);
		  if((Mat[i][24]).contains("Lunes")){
			  Mat[i][24] = "LAM";
			  f++;
		  }
		  if((Mat[i][24]).contains("Martes")){
			  if(f == 0) {
				  Mat[i][24] = "MAM";
			  }else {
				  Mat[i][24] = Mat[i][24] + "MAM";
				  f++;
				  }
		  }
		  if((Mat[i][24]).contains("Miercoles")){
			  if(f == 0) {
				  Mat[i][24] = "WAM";
			  }else {
				  Mat[i][24] = Mat[i][24] + "WAM";
				  f++;
				  }
		  }
		  if((Mat[i][24]).contains("Jueves")){
			  if(f == 0) {
				  Mat[i][24] = "JAM";
			  }else {
				  Mat[i][24] = Mat[i][24] + "JAM";
				  f++;
				  }
		  }
		  if((Mat[i][24]).contains("Viernes")){
			  if(f == 0) {
				  Mat[i][24] = "VAM";
			  }else {
				  Mat[i][24] = Mat[i][24] + "VAM";
				  f++;
				  }
		  }
		  if((Mat[i][24]).contains("Sabado")){
			  if(f == 0) {
				  Mat[i][24] = "SAM";
			  }else {
				  Mat[i][24] = Mat[i][24] + "SAM";
				  f++;
				  }
		  }
		  if((Mat[i][24]).contains("Domingo")){
			  if(f == 0) {
				  Mat[i][24] = "DAM";
			  }else {
				  Mat[i][24] = Mat[i][24] + "DAM";
				  f++;
				  }
		  }
		  
		  }
		  System.out.println(Mat[0][24]);
		  System.out.println(Mat[1][24]);
		  System.out.println(Mat[2][24]);
		  System.out.println(Mat[3][24]);
		  
		
	}/**/
	 
	 void leerEstudiantes(EstudianteM[] est, String fileEst) {
		 String file = fileEst;
		  BufferedReader reader = null;
		  String line = "";
		  int numLineas = 0;
		  
		  try {
		   reader = new BufferedReader(new FileReader(file));
		   reader.readLine();
		   while((line = reader.readLine()) != null) {
			est[numLineas]=new EstudianteM();
			line=line.replaceAll("\"", "");
		    String[] row = line.split(",");
		    if(row[4].contains("id")) {
		    	
		    }else {
		    	est[numLineas].id=Integer.parseInt(row[4]);
			    est[numLineas].genero=row[2].charAt(0);
			    if(row[13].equals("Si"))
			    	est[numLineas].limitacion=true;
			    else
			    	est[numLineas].limitacion=false;
	
		    	est[numLineas].localidad=row[7];
		    	est[numLineas].nombre=row[1];
		    	est[numLineas].correo=row[3];
		    	est[numLineas].disponibilidad=this.obtenerDia(row[24])+"AM;"+this.obtenerDia(row[25])+"PM";
		    	est[numLineas].tipoOrg=row[29];
		    	est[numLineas].tipoEmp=row[30];
		    	est[numLineas].actividadEco=row[31];
		    	est[numLineas].comunidad=row[32];
		    	est[numLineas].modalidad=row[23].charAt(0);
		    	if(row[12].equals("No"))
		    		est[numLineas].experiencia=false;
		    	else
		    		est[numLineas].experiencia=true;
		    	if(row[19].equals("Menor a 4"))
		    		est[numLineas].promedio=false;
		    	else
		    		est[numLineas].promedio=true;
		    	est[numLineas].contacto=row[21];
		    	
			    numLineas++;
		    }
		    
		   }
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
	 }
	 
	 void leerEmpredimientos(EmprendimientoM[] emp, String fileEmp) {
		  String file = fileEmp;
		  BufferedReader reader = null;
		  String line = "";
		  int numLineas = 0;
		  
		  try {
		   reader = new BufferedReader(new FileReader(file));
		   reader.readLine();
		   while((line = reader.readLine()) != null) {
			emp[numLineas]=new EmprendimientoM();
			line=line.replaceAll("\"", "");
		    String[] row = line.split(",");
		    if(row[0].equals("id")) {
		    	
		    }else {
		    	emp[numLineas].id=Integer.parseInt(row[0]);
			    emp[numLineas].genero=row[1].charAt(0);
			    if(row[2].equals("Si"))
			    	emp[numLineas].limitacion=true;
			    else
			    	emp[numLineas].limitacion=false;
	
		    	emp[numLineas].localidad=row[3];
		    	emp[numLineas].disponibilidad=row[4];
		    	emp[numLineas].tipoOrg=row[5];
		    	emp[numLineas].tipoEmp=row[6];
		    	emp[numLineas].actividadEco=row[7];
		    	emp[numLineas].comunidad=row[8];
		    	emp[numLineas].modalidad=row[9].charAt(0);
		    	if(row[10].equals("Si"))
		    		emp[numLineas].experiencia=true;
		    	else
		    		emp[numLineas].experiencia=false;
		    	if(row[11].equals("Si"))
		    		emp[numLineas].promedio=true;
		    	else
		    		emp[numLineas].promedio=false;
		    	emp[numLineas].contacto=row[12];
		    	
			    numLineas++;
		    }
		    
		   }
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
	 }
	 
	 char obtenerDia(String dia) {
		 char inicial=' ';
		 if(dia.contains("Lunes")){
			  inicial = 'L';
		 }
		 else if(dia.contains("Martes")){
			 inicial = 'M';
		  }
		 else if(dia.contains("Miercoles")){
			 inicial = 'W';
		  }
		 else if(dia.contains("Jueves")){
			inicial = 'J';
		  }
		 else if(dia.contains("Viernes")){
			inicial = 'V';
		  }
		 else if(dia.contains("Sabado")){
			inicial = 'S';
		  }
		 else if(dia.contains("Domingo")){
			inicial = 'D';
		 }
		 
		 return inicial;
	}
	 
	 void leerPreinscritos(Mpreinscrito[] est, String fileEst) {
		 String file = fileEst;
		  BufferedReader reader = null;
		  String line = "";
		  int numLineas = 0;
		  
		  try {
		   reader = new BufferedReader(new FileReader(file));
		   reader.readLine();
		   while((line = reader.readLine()) != null) {
			est[numLineas]=new Mpreinscrito();
			line=line.replaceAll("\"", "");
		    String[] row = line.split(",");
		    System.out.println(line);
		    if(row[4].contains("id")) {
		    	
		    }else {
		    	est[numLineas].nombre=row[1];
			    est[numLineas].correo=row[2];
			    est[numLineas].telefono=row[8];
			    est[numLineas].asignatura=row[5];
			    est[numLineas].idEstudiantil=row[3].trim();//Long.parseLong(row[3].trim());;
			    est[numLineas].identificacion=row[4].trim();//=Long.parseLong(row[4].trim());
			    est[numLineas].tallerSP=row[6];
			    est[numLineas].fechaSP=row[7];
			    est[numLineas].infografia=row[9];		    	
			    numLineas++;
		    }
		    
		   }
		  }
		  catch(Exception e) {
		   e.printStackTrace();
		  }
		  finally {
		   try {
		    reader.close();
		   } catch (IOException e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		   }
		  }
	 }
}