package com.aantik.demo.tejido;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.model.CIIU;
import com.aantik.demo.model.ModCiiuXemp;
import com.aantik.demo.model.tejidoSocial;

public class leerExcelTejido {

	  public int leerTejido(InputStream is,tejidoSocial[] lista) {
	    try {
	      Workbook workbook = new XSSFWorkbook(is);
	      Sheet sheet = workbook.getSheetAt(3);
	      Iterator<Row> rows = sheet.iterator();
	      Sheet sheet2=workbook.getSheetAt(3);   //getting the XSSFSheet object at given index  
		  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
	      //System.out.println("xcol: "+colNumber);	   
	      int rowNumber = 0, cant=0;	      
	      while (rows.hasNext()) {

		    
	        rowNumber++;
	        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
	          if(row==null) {
	        	  break;
	          }
	        Cell cell; 
	         //getting the cell representing the given column     //getting cell value  
	        int cellIdx = 0;
	        String value2;
	        while (cellIdx<colNumber) {
	          cell=row.getCell(cellIdx);
	          lista[cant]=new tejidoSocial();
	          if(cell!=null) {
		          if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		        	  value2= String.valueOf(cell.getNumericCellValue());
		          else
			  	      value2= String.valueOf(cell.getStringCellValue());
		          if(value2.length()!=0) {
		        	  if (value2.equals("x")||value2.equals("X")) {
		        		  lista[cant].emprenOrigen= (long)(row.getCell(3).getNumericCellValue());
		        		  lista[cant].emprenDest=(long)(sheet2.getRow(3).getCell(cellIdx).getNumericCellValue());
		        		  String idpi=lista[cant].emprenOrigen.toString()+lista[cant].emprenDest.toString();
		        		  lista[cant].id=(long) Float.parseFloat(idpi);
		        		  //System.out.println("Origen: "+lista[cant].emprenOrigen+
			        			//  " destino: "+lista[cant].emprenDest+" id: "+lista[cant].id); 
		        		  cant++;
		        	  }
			        	  
		        	  
		          }	          
	          }	        	  
	          cellIdx++;
	       }

	    }

    	 // System.out.println("CLOSE: "+cant);	
	      return cant;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
	  
	  public int getDatosCiiu(InputStream is, CIIU[] lista) {
		    try {
		      Workbook workbook = new XSSFWorkbook(is);
		      Sheet sheet = workbook.getSheetAt(3);
		      Iterator<Row> rows = sheet.iterator();
		      Sheet sheet2=workbook.getSheetAt(3);   //getting the XSSFSheet object at given index  
			  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
		      //System.out.println("xcol: "+colNumber);	   
		      int rowNumber = 3;
		      int rowDatos=0;
		      while (rows.hasNext()) {
		    	int cellIdx = 0;
		        // skip header
		    	lista[rowDatos]=new CIIU();
		        rowNumber++;
		        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
		          if(row==null) {
		        	  break;
		          }
		        Cell cell; 
		        String value2;
			          cell=row.getCell(cellIdx);

			          if(cell!=null) {
				          if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
				        	  value2= String.valueOf(cell.getNumericCellValue());
				          else
					  	      value2= String.valueOf(cell.getStringCellValue());
				          if(value2.length()!=0) {
				        	//  System.out.println("val---"+value2);
					        	  lista[rowDatos].tipo=row.getCell(0).getStringCellValue();
					        	  lista[rowDatos].sector=row.getCell(1).getStringCellValue();
					        	  lista[rowDatos].agrupacion=(long)(row.getCell(2).getNumericCellValue());
					        	  lista[rowDatos].codigo=(long)(row.getCell(3).getNumericCellValue());
					        	  lista[rowDatos].descripcion=row.getCell(4).getStringCellValue();
					        	  rowDatos++; 
				          }	
				          
			          }	        	  
			          cellIdx++;			                	
		      }

	    	//  System.out.println("CLOSE: "+rowDatos);	
      		return rowDatos;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }
	  
	  public void getActividad(InputStream is, CIIU[] lista,int tamLista) {
		  	String actividad= null;
		    try {
		      Workbook workbook = new XSSFWorkbook(is);
		      Sheet sheet = workbook.getSheetAt(1);
		      Iterator<Row> rows = sheet.iterator();
		      Sheet sheet2=workbook.getSheetAt(1);   //getting the XSSFSheet object at given index  
			  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
		     // System.out.println("xcol: "+colNumber);	   		     
		      int rowDatos=0;
		      for(int i=0;i<tamLista;i++) {
		    	 // System.out.println(lista[i].codigo);
		    	  int rowNumber = 0;
			      while (rows.hasNext()) {
			        rowNumber++;
			        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
			          if(row==null) {
			        	  break;
			          }
			        Cell cell;
			        String value; 
			        Long value2;
			          cell=row.getCell(1);
			          if(cell!=null) {
				  	      value2= (long)(cell.getNumericCellValue());
				          cell=row.getCell(0);
				  	      value= String.valueOf(cell.getStringCellValue());
				          if(value.length()!=0) {
				        	  actividad=value;
				          }
				          if(lista[i].agrupacion.equals(value2)) {
				        	  lista[i].actividad=actividad;
				  //      	  System.out.println("Actividad: "+lista[i].actividad+
		      		//	  " agrupacion: "+value2+" "+lista[i].codigo); 
				        	  break;
				          }
				          rowDatos++;			        	  
			          }	        	
			      }
		      }
	    	//  System.out.println("CLOSE: "+rowDatos);	
    		return;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
		  }

	public int getCuzeInf(FileInputStream fis2, ModCiiuXemp[] lista) {
	// TODO Auto-generated method stub
	String actividad= null;
    try {
	      Workbook workbook = new XSSFWorkbook(fis2);
	      Sheet sheet = workbook.getSheetAt(2);
	      Iterator<Row> rows = sheet.iterator();
	      Sheet sheet2=workbook.getSheetAt(2);   //getting the XSSFSheet object at given index  
		  int colNumber = sheet2.getRow(1).getPhysicalNumberOfCells();
	      System.out.println("xcol: "+colNumber);	   		     
	      int rowDatos=0,catDat=0;
	    	  //System.out.println(cruzar[i].codigo);
    	  int rowNumber = 2;
	      while (rows.hasNext()) {
	        rowNumber++;
	        lista[catDat]=new ModCiiuXemp();
	        lista[catDat].nombreEmp="gofl";
	        		 lista[catDat].idCiiu=(long) 12321;
	        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
	          if(row==null) {
	        	  break;
	          }
	        Cell cell;
	        String value; 
	        Long value2;
	        cell=row.getCell(1);
	       // System.out.println("rn "+rowNumber+"cd "+catDat+lista[catDat].nombreEmp);
	        if(cell!=null) {
	        	if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC) {
		  	      value2= (long)(cell.getNumericCellValue());
		          cell=row.getCell(3);
		          if(cell!=null) {
		  	      value= String.valueOf(cell.getStringCellValue());
		          if(value.length()!=0) {
		        	  actividad=value;
		          }
		        	  for(int i=3;i<colNumber;i++) {
		        		  if(row.getCell(i)!=null) {
		        			value=row.getCell(i).getStringCellValue();
			        		  if( value.length()>1) {
			        			   lista[catDat].id=row.getCell(1).getNumericCellValue()+"-"+i;
			        			   lista[catDat].idCiiu=(long) row.getCell(1).getNumericCellValue();
			        			   lista[catDat].nombreEmp=row.getCell(i).getStringCellValue();
			        		       //System.out.println("nombre emp: "+lista[catDat].nombreEmp+"ciiu nm  "+lista[catDat].idCiiu);
			        			   catDat++;
			        		       lista[catDat]=new ModCiiuXemp();
			        		  }  
		        		  }		        		  
		        	  }
		          }
		         rowDatos++;
	        	}
	          }	        	
	      }
  		return catDat;
		    } catch (IOException e) {
		      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		    }
	}
}
