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
import com.aantik.demo.model.ModEmprendimiento;

public class leerEmprendimientos {
	
	 public void getEmprendimientos(InputStream is, ModEmprendimiento[] lista) {
		  	String actividad= null;
		  	try {
		    Workbook workbook = new XSSFWorkbook(is);
		      Sheet sheet = workbook.getSheetAt(1);
		      Iterator<Row> rows = sheet.iterator();
		      Sheet sheet2=workbook.getSheetAt(1);   //getting the XSSFSheet object at given index  
			  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
		      System.out.println("xcol: "+colNumber);	   
		      int rowNumber = 1;
		      int rowDatos=0;
		      while (rows.hasNext()) {
		    	int cellIdx = 0;
		        // skip header
		    	lista[rowDatos]=new ModEmprendimiento();
		        rowNumber++;
		        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
		          if(row==null ) {
		        	  break;
		          }else if(row.getCell(1)==null || row.getCell(1).getStringCellValue().length()<1)
		        	  break;
		          else
		        	  System.out.println("NO ES NULO ES:"+row.getCell(1));
		        Cell cell; 
		        String value2=null;
		        cellIdx++;
		        	  for(int i=0;i<colNumber;i++) {
			          cell=row.getCell(i);
			          if(cell==null )
		        			  value2=null;
			          if(cell!=null) {
			        		  if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
				        	  value2= String.valueOf((long)cell.getNumericCellValue());
				          else
					  	      value2= String.valueOf(cell.getStringCellValue());
			        	System.out.println(value2);	  
			          }
				          switch(i) {
				          case 0:
				        	  lista[rowDatos].id=rowNumber;
				        	  break;
				        	  case 1:
					       	  lista[rowDatos].nombreEmp=value2;//row.getCell(1).getStringCellValue();
					       	  break;
				        	  case 2:
					        	  lista[rowDatos].nitId=value2;//row.getCell(2).getStringCellValue();
					        	  break;
				        	  case 3:
					        	  lista[rowDatos].fechaCons=value2;//Long.parseLong(value2);
					        	  break;
				        	  case 4:
				        		  lista[rowDatos].direccion=value2;
					        	  break;
				        	  case 5:
					        	  lista[rowDatos].orgSocial=value2;
					        	  break;
				        	  case 6:
					        	  lista[rowDatos].localidad=value2;
					        	  break;
				        	  case 7:
					        	  lista[rowDatos].barrio=value2;
					        	  break;
				        	  case 8:
				        		  lista[rowDatos].temaAsesorar=value2;
				        		  break;
			        		case 9:
			        		  lista[rowDatos].interlocutorEmp=value2;
			        		  break;
			        		case 10:
			        			  lista[rowDatos].telefonoIE=value2;
			        			  break;
			        		case 11:
			        		    lista[rowDatos].correoIE=value2;
			        		    break;
			        		case 12:
			        		    lista[rowDatos].nombreInterOS=value2;
			        		    break;
			        		case 13:
			        		    lista[rowDatos].telefonoIOS=value2;
			        		    break;
			        		case 14:
			        		    lista[rowDatos].correoIOS=value2;
			        		    break;
			        		case 15:
			        		    lista[rowDatos].cupos=Integer.parseInt(value2);//**p
			        		    break;
			        		case 16:
			        		    lista[rowDatos].empleados=value2;
			        		    break;
			        		case 17:
			        		    lista[rowDatos].linAccion=value2;//**p
			        		    break;
			        		case 18:
			        		    lista[rowDatos].actividadEco=value2;//**
			        		    break;
			        		case 19:
			        		    lista[rowDatos].prodServ=value2;
			        		    break;
			        		case 20:
			        		    lista[rowDatos].contacto=value2;//medio de comunicacion que prefiere**
			        		    break;
			        		case 21:
			        		    lista[rowDatos].experiencia=getBolVal(value2);//**
			        		    break;
			        		case 22:
			        		    lista[rowDatos].promedio=getBolVal(value2);//**
			        		    break;
			        		case 23:
			        		    lista[rowDatos].horarioNotif=value2;
			        		    break;
			        		case 24:
			        		    lista[rowDatos].modalidad=value2.charAt(0);//**
			        		    break;
			        		case 25:
			        		    lista[rowDatos].horarioAtencion=value2;
			        		    break;
			        		case 26:
			        		    lista[rowDatos].disponibilidad=value2;
			        		    break;
			        		case 27:
			        		    lista[rowDatos].genero=value2.charAt(0);//**
			        		    break;
			        		case 28:
			        		    lista[rowDatos].limitacion=getBolVal(value2);
			        		    break;
			        		case 29:
			        		    lista[rowDatos].comunidad=value2;
			        		    break;
			        		case 30:
			        		    lista[rowDatos].transporte=getBolVal(value2);//*p
			        		    break;
					         }	  
		   
			          }	System.out.println(lista[rowDatos].id+" "+lista[rowDatos].nombreEmp+" "+lista[rowDatos].nitId+" "+
					        			  lista[rowDatos].fechaCons+" "+lista[rowDatos].direccion+" "+
					        			  lista[rowDatos].temaAsesorar+
					        			  " "+lista[rowDatos].orgSocial+" "+lista[rowDatos].localidad
					        			  +" "+lista[rowDatos].genero+" "+lista[rowDatos].telefonoIE);
					        	  rowDatos++; 
				                 	  
			         // cellIdx++;			                	
		      }

	    	//  System.out.println("CLOSE: "+rowDatos);	
 		return;// rowDatos;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
	 
	 public boolean getBolVal(String valor) {
		 if(valor.equals("Si"))
			 return true;
		 return false;
	 }
	 
}
