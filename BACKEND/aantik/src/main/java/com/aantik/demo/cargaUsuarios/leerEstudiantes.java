package com.aantik.demo.cargaUsuarios;

import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aantik.demo.model.ModEstudiante;
import com.aantik.demo.model.Mpreinscrito;

public class leerEstudiantes {
	
	  public void getPreinscritos(InputStream is, Mpreinscrito[] lista) {
		  	String actividad= null;
		  	try {
		    Workbook workbook = new XSSFWorkbook(is);
		      Sheet sheet = workbook.getSheetAt(0);
		      Iterator<Row> rows = sheet.iterator();
		      Sheet sheet2=workbook.getSheetAt(0);   //getting the XSSFSheet object at given index  
			  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
		      System.out.println("xcol: "+colNumber);	   
		      int rowNumber = 0;
		      int rowDatos=0;
		      while (rows.hasNext()) {
		    	int cellIdx = 0;
		        // skip header
		    	lista[rowDatos]=new Mpreinscrito();
		        rowNumber++;
		        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
		          if(row==null) {
		        	  break;
		          }
		        Cell cell; 
		        String value2=null;
		        	  for(int i=1;i<10;i++) {
			          cell=row.getCell(i);
			          if(cell==null )
		        			  value2=null;
			          if(cell!=null) {
			        		  if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
				        	  value2= String.valueOf(cell.getNumericCellValue());
				          else
					  	      value2= String.valueOf(cell.getStringCellValue());
			        		  
			          }
				          switch(i) {
				        	  case 1:
					       	  lista[rowDatos].nombre=value2;//row.getCell(1).getStringCellValue();
					       	  break;
				        	  case 2:
					        	  lista[rowDatos].correo=value2;//row.getCell(2).getStringCellValue();
					        	  break;
				        	  case 3:
					        	  lista[rowDatos].idEstudiantil=value2;//Long.parseLong(value2);
					        	  break;
				        	  case 4:
				        		  lista[rowDatos].identificacion=value2;
					        	  break;
				        	  case 5:
					        	  lista[rowDatos].asignatura=value2;
					        	  break;
				        	  case 6:
					        	  lista[rowDatos].tallerSP=value2;
					        	  break;
				        	  case 7:
					        	  lista[rowDatos].fechaSP=value2;
					        	  break;
				        	  case 8:
									lista[rowDatos].telefono=value2;
									break;
				        	  case 9:
					        	  lista[rowDatos].infografia=value2;
					        	  break;
					         }	  
					        	  
			        	 
				          
				          
			          }	System.out.println(" "+lista[rowDatos].nombre+" "+lista[rowDatos].correo+" "+
					        			  lista[rowDatos].telefono+" "+lista[rowDatos].direccion+" "+
					        			  lista[rowDatos].asignatura+" "+lista[rowDatos].idEstudiantil+
					        			  " "+lista[rowDatos].identificacion+" "+lista[rowDatos].tallerSP
					        			  +" "+lista[rowDatos].fechaSP+" "+lista[rowDatos].infografia);
					        	  rowDatos++; 
				                 	  
			          cellIdx++;			                	
		      }

	    	//  System.out.println("CLOSE: "+rowDatos);	
    		return;// rowDatos;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
	  /*primera version del software una excel para los datos
	  de los estuciantes, tanto basicos como de perzonalizacion*/
	  public int getInscritos(InputStream is, ModEstudiante[] lista) {
		  	String actividad= null;
		  	try {
		    Workbook workbook = new XSSFWorkbook(is);
		      Sheet sheet = workbook.getSheetAt(0);
		      Iterator<Row> rows = sheet.iterator();
		      Sheet sheet2=workbook.getSheetAt(0);   //getting the XSSFSheet object at given index  
			  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
		      System.out.println("xcol: "+colNumber);	   
		      int rowNumber = 0;
		      int rowDatos=0;
		      while (rows.hasNext()) {
		    	int cellIdx = 0;
		        // skip header
		    	lista[rowDatos]=new ModEstudiante();
		        rowNumber++;
		        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
		          if(row==null) {
		        	  break;
		          }else if(row.getCell(1)==null || row.getCell(1).getStringCellValue().length()<1)
		        	  break;
		        Cell cell; 
		        String value=null;
		        	  for(int i=1;i<=colNumber;i++) {
			          cell=row.getCell(i);
			          if(cell==null )
		        			  value=null;
			          if(cell!=null) {
			        		  if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
				        	  value= String.valueOf((long)cell.getNumericCellValue());
				          else
					  	      value= String.valueOf(cell.getStringCellValue());
			       // System.out.println("-"+i+"--"+value);	  
			          }
				          switch(i) {
				        	case 1: 
				        	    lista[rowDatos].nombre=value;
				        	    break;
				        	case 2: 
				        	    lista[rowDatos].genero=value.charAt(0);
				        	    break;
				        	case 3: 
			        		    lista[rowDatos].correo=value;
			        		    break;
			        		case 4: 
				        	    lista[rowDatos].id=Integer.parseInt(value);
			        		    lista[rowDatos].documento=value;
			        		    break;
			        		case 5: 
			        		    lista[rowDatos].telefono=value;
			        		    break;
			        		case 6: 
			        		    lista[rowDatos].ciudad=value;
			        		    break;
			        		case 7: 
			        		    lista[rowDatos].localidad=value;
			        		    break;
			        		case 8: 
			        		    lista[rowDatos].barrio=value;
			        		    break;
			        		case 9: 
			        		    lista[rowDatos].direccion=value;
			        		    break;
			        		case 10: 
			        		    lista[rowDatos].actividadExtra=getBolVal(value);
			        		    break;
			        		case 12: 
			        		    lista[rowDatos].experiencia=getBolValN(value);
			        		    break;
			        		case 13: 
			        		    lista[rowDatos].limitacion=getBolVal(value);
			        		    break;
			        		case 14: 
			        		    lista[rowDatos].limitLocalidad=value;
			        		    break;
			        		case 15: 
			        		    lista[rowDatos].transporte=getBolValN(value);
			        		    break;
			        		case 16: 
			        		    lista[rowDatos].asignatura=value;
			        		    break;
			        		case 17: 
			        		    lista[rowDatos].docentePref=value;
			        		    break;
			        		case 18: 
			        		    lista[rowDatos].docenteNoPref=value;
			        		    break;
			        		case 19: 
			        		    lista[rowDatos].promedio=getBolValP(value.substring(0,2));
			        		    break;
			        		case 20: 
			        		    lista[rowDatos].enfasis=value;
			        		    break;
			        		case 21: 
			        		    lista[rowDatos].contacto=value;
			        		    break;
			        		case 22: 
			        		    lista[rowDatos].linAccion=value;
			        		    break;
			        		case 23: 
			        		    lista[rowDatos].modalidad=value.charAt(0);
			        		    break;
			        		case 24: 
			        		    lista[rowDatos].disponibilidad=value;
			        		    break;	
			        	  case 26: 
			        		    lista[rowDatos].notificaciones=value;
			        		    break;
			        		case 29: 
			        		    lista[rowDatos].tipoOrg=value;
			        		    break;
			        		case 30: 
			        		    lista[rowDatos].tipoEmp=value;
			        		    break;
			        		case 31: 
			        		    lista[rowDatos].actividadEco=value;
			        		    break;
			        		case 32: 
			        		    lista[rowDatos].comunidad=value;
			        		    break;
			        		case 33: 
			        		    lista[rowDatos].pUbicacion=Integer.parseInt(value);
			        		    break;
			        		case 34: 
			        		    lista[rowDatos].pDispponibilidad=Integer.parseInt(value);
			        		    break;
			        		case 35: 
			        		    lista[rowDatos].pActividad=Integer.parseInt(value);
			        		    break;
			        		case 36: 
			        		    lista[rowDatos].pTipoOrg=Integer.parseInt(value);
			        		    break;
			        		case 37: 
			        		    lista[rowDatos].pComunidad=Integer.parseInt(value);
			        		    break;
		        	  	}
				          
			          }	System.out.println(" "+lista[rowDatos].id+" "+lista[rowDatos].nombre+" "+
					        			  lista[rowDatos].genero+" "+lista[rowDatos].direccion+" "+
					        			  lista[rowDatos].limitacion+" "+lista[rowDatos].transporte+
					        			 " "+lista[rowDatos].docentePref+" "+lista[rowDatos].disponibilidad
					        			  +" "+lista[rowDatos].comunidad+" "+lista[rowDatos].pComunidad);
					        	  rowDatos++; 
				                 	  
			          cellIdx++;			                	
		      }

	    	//  System.out.println("CLOSE: "+rowDatos);	
  		return rowDatos;// rowDatos;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
	  
	  public boolean getBolVal(String valor) {
			 if(valor.equals("Si"))
				 return true;
			 return false;
		 }
	  public boolean getBolValN(String valor) {
			 if(!valor.equals("No"))
				 return true;
			 return false;
		 }
	  public boolean getBolValP(String valor) {
		  System.out.println("--BOL Prom"+valor);
			 if(!valor.equals("Me"))
				 return true;
			 return false;
		 }
}
