package com.aantik.demo.service;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.HelperClassServices.AddUsers;
import com.aantik.demo.entidad.Estudiante;

public class PreinscExcelReader {

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String SHEET = "preinsc";

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
          return false;
        }
    
        return true;
      }

      public static List<Estudiante> excelToTutorials(InputStream is) {
        try {
          Workbook workbook = new XSSFWorkbook(is);
          Sheet sheet = workbook.getSheet(SHEET);

          Iterator<Row> rows = sheet.iterator();
          List<Estudiante> tutorials = new ArrayList<Estudiante>();
          int rowNumber = 0;
          while (rows.hasNext()) {
            Row currentRow = rows.next();
    
            // skip header
            if (rowNumber == 0) {
              rowNumber++;
              continue;
            }
    
            Iterator<Cell> cellsInRow = currentRow.iterator();
    
            Estudiante tutorial = new Estudiante();
            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
              Cell currentCell = cellsInRow.next();

              switch (cellIdx) {
                //System.out.println("llegue 9");
              case 0:
               // tutorial.setIndicaid(currentCell.getStringCellValue());
                //System.out.println(currentCell.getStringCellValue());
                break;
                
              case 1:
                tutorial.setNombre(currentCell.getStringCellValue());
                break;

              case 2:
                tutorial.setCorreo(currentCell.getStringCellValue());
                break;

              case 3:
                tutorial.setIdEstudiantil(currentCell.getStringCellValue());
                break;

                case 4:
                tutorial.setDocumento(currentCell.getStringCellValue());
                System.out.println(currentCell.getStringCellValue());
                break;

                case 5:
                tutorial.setAsignatura(currentCell.getStringCellValue());
                System.out.println(currentCell.getStringCellValue());
                break;

                case 6:
                
                System.out.println(currentCell.getStringCellValue());
                break;

                case 7:
                tutorial.setFechaSP(currentCell.getStringCellValue());
                System.out.println(currentCell.getStringCellValue());
                break;

                case 8:
                tutorial.setTelefono(currentCell.getStringCellValue());
                System.out.println(currentCell.getStringCellValue());
                break;

                case 9:
                tutorial.setInfografia(currentCell.getStringCellValue().split(",")[0]);
                tutorial.setStatus(0);
                System.out.println(currentCell.getStringCellValue());
                break;
    
              default:
                break;
              }
    
              cellIdx++;
            }

            tutorials.add(tutorial);
          }   
          //workbook.close();   
          return tutorials;
        } catch (IOException e) {
          throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
      }
}
