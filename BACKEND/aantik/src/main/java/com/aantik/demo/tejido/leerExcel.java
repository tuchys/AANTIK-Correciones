package com.aantik.demo.tejido;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.springframework.web.multipart.MultipartFile;

public class leerExcel {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	  static String SHEET = "Sheet1";

	  public static boolean hasExcelFormat(MultipartFile file) {

	    if (!TYPE.equals(file.getContentType())) {
	      return false;
	    }

	    return true;
	  }

	  public static void excelToTutorials(InputStream is) {
	    try {
	      Workbook workbook = new XSSFWorkbook(is);
	      Sheet sheet = workbook.getSheet(SHEET);
	      Iterator<Row> rows = sheet.iterator();

	      int rowNumber = 0;
	      while (rows.hasNext()) {

	        // skip header
	        rowNumber++;
	        Sheet sheet2=workbook.getSheetAt(0);   //getting the XSSFSheet object at given index  
	        Row row=sheet2.getRow(rowNumber);  //returns the logical row      
	          if(row==null) {
	        	  break;
	          }
	        Cell cell; 
	         //getting the cell representing the given column     //getting cell value  
	        int cellIdx = 0;
	        String value2;
	        while (cellIdx<10) {
	          cell=row.getCell(cellIdx);          
	          
	          switch (cellIdx) {
	          case 0:
	        	if(cell!=null) {
	        	  value2= String.valueOf(cell.getNumericCellValue());
	        	  System.out.println("val"+value2); 
	        	}	  	        
	            break;

	          case 1:
        	  if(cell!=null) {
		  	        value2= String.valueOf(cell.getStringCellValue());
			        System.out.println("val"+value2);
		        }
	            break;

	          case 2:
        	  if(cell!=null) {
		  	        value2= String.valueOf(cell.getStringCellValue());
			        System.out.println("val"+value2);
		        } 
	            break;

	          case 3:
	        	 if(cell!=null) {
	        	  value2= String.valueOf(cell.getStringCellValue());
	        	  System.out.println("val"+value2); 
	        	}	  	
	            break;

	          case 4:
	        	 if(cell!=null) {
	        	  value2= String.valueOf(cell.getStringCellValue());
	        	  System.out.println("val"+value2); 
	        	}	  	
	            break;
		        
	          case 5:
        	  if(cell!=null) {
		  	        value2= String.valueOf(cell.getStringCellValue());
			        System.out.println("val"+value2);
		        }
	            break;
	           
	          case 6:
	        	 if(cell!=null) {
		  	        value2= String.valueOf(cell.getStringCellValue());
			        System.out.println("val"+value2);
		        }
	            break;
	            
	          case 7:
        	    if(cell!=null) {
		  	        value2= String.valueOf(cell.getStringCellValue());
			        System.out.println("val"+value2);
		        }
	            break;

	          case 8:
	        	 if(cell!=null) {
	        	  value2= String.valueOf(cell.getStringCellValue());
	        	  System.out.println("val"+value2); 
	        	}	  	
	            break;
	            
	          case 9:
		        if(cell!=null) {
		  	        value2= String.valueOf(cell.getStringCellValue());
			        System.out.println("val"+value2);
		        }
	            break;	
	          default:
	            break;
	          }

	          cellIdx++;
	        }

	      }

    	  System.out.println("CLOSE: ");	
	      return;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }
}
