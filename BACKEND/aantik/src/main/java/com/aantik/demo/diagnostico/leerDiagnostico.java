package com.aantik.demo.diagnostico;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.aantik.demo.model.ModConTable;
import com.aantik.demo.model.ModInfoPregunta;
import com.aantik.demo.model.ModRubrica;
import com.aantik.demo.model.ModeloPregunta;
import com.aantik.demo.model.convenciones;

public class leerDiagnostico {
	
	public int leerConvenciones(InputStream is, convenciones conven) {
	    try {	      
	      Workbook workbook = new XSSFWorkbook(is);
	      Sheet sheet = workbook.getSheetAt(2);
	      Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= sheet.getLastRowNum();
	      int rowNumber = 0, cant=0;
	      conven.AreaFuncional=new ModConTable[auxRow];
	      conven.CargoResp=new ModConTable[auxRow];
	      conven.VarOrga=new ModConTable[auxRow];
	      conven.NivelScor=new ModConTable[auxRow];
	      System.out.println("xcol: "+colNumber+" rows "+auxRow);	   	      
	      while (rows.hasNext()) {

		    
	        rowNumber++;
	        Row row=sheet.getRow(rowNumber);  //returns the logical row      
	          if(row==null) {
	        	  break;
	          }
	        Cell cell; 
	         //getting the cell representing the given column     //getting cell value  
	        int cellIdx = 0;
	        String value2;
		    conven.AreaFuncional[rowNumber-1]=new ModConTable();
		    conven.CargoResp[rowNumber-1]=new ModConTable();
		    conven.VarOrga[rowNumber-1]=new ModConTable();
		    conven.NivelScor[rowNumber-1]=new ModConTable();
	        while (cellIdx<colNumber) {
	          cell=row.getCell(cellIdx);
	          if(cell!=null) {
		          if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		        	  value2= String.valueOf(cell.getNumericCellValue());
		          else
			  	      value2= String.valueOf(cell.getStringCellValue());
		          if(value2.length()!=0) {
		        	  
		        	  if (cellIdx==0 || cellIdx==1) {
		        		 // System.out.println("AREA FUNCIONAL");
		        	      if(cellIdx==0)
		        	    	 conven.AreaFuncional[rowNumber-1].id=(int) Double.parseDouble(value2);
		        	      else
		        	    	  conven.AreaFuncional[rowNumber-1].titulo=value2;		        	    	  
		        	  }else if (cellIdx==3 || cellIdx==4) {
		        		 // System.out.println("cargo");
		        		  if(cellIdx==3)
		        	    	 conven.CargoResp[rowNumber-1].id=(int) Double.parseDouble(value2);
		        	      else
		        	    	  conven.CargoResp[rowNumber-1].titulo=value2;	
		        	  }else if (cellIdx==6 || cellIdx==7) {
		        		 // System.out.println("variable org");
		        		  if(cellIdx==6)
		        	    	 conven.VarOrga[rowNumber-1].id=(int) Double.parseDouble(value2);
		        	      else
		        	    	  conven.VarOrga[rowNumber-1].titulo=value2;	
		        	  }else if (cellIdx==9 || cellIdx==10) {
		        		 // System.out.println("nivel scor");
		        		  if(cellIdx==9)
		        	    	 conven.NivelScor[rowNumber-1].id=(int) Double.parseDouble(value2);
		        	      else
		        	    	  conven.NivelScor[rowNumber-1].titulo=value2;	
		        	  }
		        	 // System.out.println("dato "+value2+" cant "+cellIdx+" row "+rowNumber);		        	  
		          }	           
	          }	    	  
	          cellIdx++;
	       }

	    }

    	 // System.out.println("CLOSE: "+cant);	
	      return auxRow;
	    } catch (IOException e) {
	      throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
	    }
	  }

	public int leerInfoPreg(InputStream is, ModInfoPregunta[] infoPreg) {
		try {	      
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(3);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= sheet.getLastRowNum();
		  int rowNumber = 0, cant=0;
		  //infoPreg=new ModInfoPregunta[auxRow];
		  System.out.println("xcol: "+colNumber+" rows "+auxRow);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value
		
		int cellIdx = 0;
		String value2;	
		infoPreg[cant]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  infoPreg[cant].idAreaF=(int) Double.parseDouble(value2);		    		         	    	 
				  }else if (cellIdx==2) {
		    		  infoPreg[cant].idCargoR=(int) Double.parseDouble(value2);					  
				  }else if (cellIdx==4) {
		    		  infoPreg[cant].idVarOrg=(int) Double.parseDouble(value2);		
				  }else if (cellIdx==6) {
		    		  infoPreg[cant].idNivScor=(int) Double.parseDouble(value2);	
				  }else if (cellIdx==8) {
		    		  infoPreg[cant].numeroPregunta=(int) Double.parseDouble(value2);	
				  }else if (cellIdx==10) {
		    		  infoPreg[cant].pregunta=value2;
	    		  	//System.out.println(cant);	
		    		  cant++;
				  }
		  //System.out.println("dato "+value2+" cant "+cellIdx+" row "+rowNumber);		        	  
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

	public int leerPregLP(InputStream is, ModeloPregunta[] preguntas) {
		try {	      
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(5);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= -1;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					//  System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  //System.out.println(codigo);
		 // System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	
	public int leerPregCP(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(6);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregPC(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(7);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;   
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					  //System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  preguntas[auxRow].rub[cant].rubrica=Double.parseDouble(value2)*100+"% ";	
				  }else if (cellIdx==5) {
					  if(preguntas[auxRow].rub[cant].rubrica !=null)
					  preguntas[auxRow].rub[cant].rubrica=preguntas[auxRow].rub[cant].rubrica+value2;	
					  else
						  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==6) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  //System.out.println(codigo);
		 // System.out.println("dato "+value2+" cant "+auxRow+" row "+cant+"---"+cellIdx);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregQ(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(8);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregAbas(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(9);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;   
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  preguntas[auxRow].rub[cant].rubrica=Double.parseDouble(value2)*100+"% ";	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].rubrica=preguntas[auxRow].rub[cant].rubrica+value2;	
				  }else if (cellIdx==6) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  //System.out.println(codigo);
		 // System.out.println("dato "+value2+" cant "+auxRow+" row "+cant+"---"+cellIdx);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregM(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(10);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}	
	
	public int leerPregCD(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(11);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		boolean iniciado=false;
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
					 preguntas[auxRow].rub=new ModRubrica[8];
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
			    	  iniciado=true;
			    	  if(value2.equals("NA")) {
			    		  preguntas[auxRow].automatica=false;
			    		  preguntas[auxRow].rub[cant].cuanti=0;		
			    	  }else
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  
					  	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant>1 && preguntas[auxRow].rub[cant-1]==null)
						  cant--;
					  if(iniciado==false)
				    	  preguntas[auxRow].rub[cant]=new ModRubrica();	
					  
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		 // System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}	
	
	public int leerPregGC(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(12);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}	

	public int leerPregFCF(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(13);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregSI(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(14);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregCO(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(15);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null,auxval = null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;
		boolean iniciado=false;//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(row.getCell(0)!=null && String.valueOf(row.getCell(0).getStringCellValue()).length()!=0 ) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
					 preguntas[auxRow].rub=new ModRubrica[8];
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
			    	  iniciado=true;
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;
					  auxval=preguntas[auxRow].rub[cant].rubrica;	
				  }else if (cellIdx==5) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
						  	preguntas[auxRow].automatica=false;	
					 if(iniciado==false)
				    	  preguntas[auxRow].rub[cant]=new ModRubrica();						 
					  preguntas[auxRow].rub[cant].rubrica=auxval+","+value2;	
				  }else if (cellIdx==7) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		    	  //System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	 	          
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregGT(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(16);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}

	public int leerPregSegI(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(17);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(String.valueOf(row.getCell(0).getStringCellValue()).length()!=0) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		//  System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
	
	public int leerPregP(InputStream is, ModeloPregunta[] preguntas,int index) {
		try {	 
		  Workbook workbook = new XSSFWorkbook(is);
		  Sheet sheet = workbook.getSheetAt(18);
		  Iterator<Row> rows = sheet.iterator();
		  int colNumber = sheet.getRow(1).getPhysicalNumberOfCells();
		  int auxRow= index;
		  int rowNumber = 0, cant=0;
		  String codigo=null;	
		  System.out.println("xcol: "+colNumber);	   	      
		  while (rows.hasNext()) {
		
		    
		    rowNumber++;
		    Row row=sheet.getRow(rowNumber);  //returns the logical row      
		  if(row==null) {
			  break;
		  }
		Cell cell; 
		 //getting the cell representing the given column     //getting cell value  
		int cellIdx = 0;
		String value2;	//infoPreg[rowNumber-1]=new ModInfoPregunta();
		while (cellIdx<colNumber) {
		  cell=row.getCell(cellIdx);
		  if(cell!=null) {
		      if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC)
		    	  value2= String.valueOf(cell.getNumericCellValue());
		      else
		  	      value2= String.valueOf(cell.getStringCellValue());
		      if(row.getCell(0)!=null && String.valueOf(row.getCell(0).getStringCellValue()).length()!=0 ) {
		    	  codigo=String.valueOf(row.getCell(0).getStringCellValue());
		    	  cant=0;
		    	  if(cellIdx==0) {
		    		  auxRow++;
					 preguntas[auxRow]=new ModeloPregunta();
		    	  }
		    		  
		      }
		      if(value2.length()!=0) {
		    	  if (cellIdx==0) {
		    		  preguntas[auxRow].codigo=value2;        	    	  
				  }else if (cellIdx==1) {
					  preguntas[auxRow].pregunta=value2;					  
				  }else if (cellIdx==2) {
					  preguntas[auxRow].insump=value2;		
				  }else if (cellIdx==3) {
			    	  preguntas[auxRow].rub[cant]=new ModRubrica();
					  preguntas[auxRow].rub[cant].cuanti=(int) Double.parseDouble(value2);
					  if((int) Double.parseDouble(value2)==2)
					  	preguntas[auxRow].automatica=true;	
					 // System.out.println("----------"+preguntas[auxRow].rub[cant].cuanti+" cant "+auxRow+" row "+cant);
				  }else if (cellIdx==4) {
					  if(cant==4 && preguntas[auxRow].rub[1].rubrica==null)
					  	preguntas[auxRow].automatica=false;	
					  preguntas[auxRow].rub[cant].rubrica=value2;	
				  }else if (cellIdx==5) {
					  preguntas[auxRow].rub[cant].actividad=value2;
				  }
		    	  
		    	  //System.out.println(codigo);
		// System.out.println("dato "+value2+" cant "+auxRow+" row "+cant);		        	  
	          }	           
	      }	    	  
		      cellIdx++;
	   }
		cant++;
	   }
		  return auxRow;
		} catch (IOException e) {
		  throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}

