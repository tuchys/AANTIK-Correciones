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

import com.aantik.demo.model.ModDocente;

public class leerDocentes {
	 public int getDocente(InputStream is, ModDocente[] lista) {
		  	String actividad= null;
		  	try {
		    Workbook workbook = new XSSFWorkbook(is);
		      Sheet sheet = workbook.getSheetAt(2);
		      Iterator<Row> rows = sheet.iterator();
		      Sheet sheet2=workbook.getSheetAt(2);   //getting the XSSFSheet object at given index  
			  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
		      System.out.println("xcol: "+colNumber);	   
		      int rowNumber = 1;
		      int rowDatos=0;
		      while (rows.hasNext()) {
		    	int cellIdx = 0;
		        // skip header
		    	lista[rowDatos]=new ModDocente();
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
			        	//System.out.println(value2);	  
			          }
				          switch(i) {
				          case 0:
				        	  lista[rowDatos].id=rowNumber;
				        	  break;
				        	  case 1:
					       	  lista[rowDatos].nombre=value2;//row.getCell(1).getStringCellValue();
					       	  break;
				        	  case 2:
					        	  lista[rowDatos].vinculacion=value2;//row.getCell(2).getStringCellValue();
					        	  break;
				        	  case 3:
					        	  lista[rowDatos].titulo=value2;//Long.parseLong(value2);
					        	  break;
				        	  case 4:
				        		  lista[rowDatos].especialidad=value2;
					        	  break;
				        	  case 5:
					        	  lista[rowDatos].asignatura=value2;
					        	  break;
				        	  case 6:
					        	  lista[rowDatos].telefono=value2;
					        	  break;
				        	  case 7:
			        		    lista[rowDatos].correo=value2;
				        		 break;
				        	  case 8:
			        		    lista[rowDatos].oficina=value2;
			        		    break;
			        		case 9:
			        		    lista[rowDatos].direcRes=value2;
			        		    break;
			        		case 10:
				        		  lista[rowDatos].localidad=value2;
			        			  break;
			        		case 11:
			        		    lista[rowDatos].sectoEc=value2;//**p
			        		    break;
			        		case 12:
			        		    lista[rowDatos].hisAse=value2;
			        		    break;
			        		case 13:
			        		    lista[rowDatos].contacto=value2;//**p
			        		    break;
			        		case 14:
			        		    lista[rowDatos].lineaAc=value2;//**
			        		    break;
			        		case 15:
			        		    lista[rowDatos].secEco2=value2;//**
			        		    break;
			        		case 16:
			        		    lista[rowDatos].tipoOS=value2;
			        		    break;
			        		case 17:
			        		    lista[rowDatos].horarioNotif=value2;//medio de comunicacion que prefiere**
			        		    break;
			        		case 18:
			        		    lista[rowDatos].horarioAtencion=value2;//**
			        		    break;
			        		case 19:
			        		    lista[rowDatos].nOdisponibilidad=value2;//**
			        		    break;
			        		case 20:
			        		    lista[rowDatos].horarioNotif=value2;
			        		    break;
			        		case 21:
			        		    lista[rowDatos].limitacion=getBolVal(value2);
			        		    break;
					         }	  
		   
			          }	System.out.println(lista[rowDatos].id+" "+lista[rowDatos].nombre+" "+lista[rowDatos].vinculacion+" "+
					        			  lista[rowDatos].correo+" "+lista[rowDatos].localidad+" "+
					        			  lista[rowDatos].contacto);
					        	  rowDatos++; 
				                 	  
			         // cellIdx++;			                	
		      }

	    	//  System.out.println("CLOSE: "+rowDatos);	
		return rowDatos+1;// rowDatos;
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
