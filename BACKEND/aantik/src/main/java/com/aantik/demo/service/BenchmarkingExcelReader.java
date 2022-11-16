package com.aantik.demo.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.entidad.BenchmarkingIndica;
import com.aantik.demo.entidad.PreguntasModeloB;
import com.aantik.demo.model.PreguntaModeloB;
import com.aantik.demo.repositorio.BenchPregunRepository;
import com.aantik.demo.repositorio.PreguntasRepository;


public class BenchmarkingExcelReader {

      @Autowired
      BenchPregunRepository benchPregunRepository;

    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    //static String[] HEADERs = { "Id", "Preguntas", "Descriptions" };
    static String SHEET = "Preguntas";
    static Integer e = 1;
    static String Cat;
    static Set<PreguntasModeloB> defs = new HashSet<>();
    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
          return false;
        }
    
        return true;
      }

      public static List<BenchmarkingIndica> excelToTutorials(InputStream is) {

        PreguntasRepository tt;

        try {
          Workbook workbook = new XSSFWorkbook(is);
          
          Sheet sheet = workbook.getSheet(SHEET);
          Iterator<Row> rows = sheet.iterator();
          
          List<BenchmarkingIndica> tutorials = new ArrayList<BenchmarkingIndica>();
    
          int rowNumber = 0;
          while (rows.hasNext()) {
            Row currentRow = rows.next();
    
            // skip header
            if (rowNumber == 0) {
              rowNumber++;
              continue;
            }
    
            Iterator<Cell> cellsInRow = currentRow.iterator();
    
            //BenchmarkingIndica tutorial = new BenchmarkingIndica();
           // BenchmarkingIndica tut = new BenchmarkingIndica();
            int cellIdx = 0;
            while (cellsInRow.hasNext()) {
              Cell currentCell = cellsInRow.next();
    
              switch (cellIdx) {
              case 0:
              
                //tutorial.    ((String) currentCell.getStringCellValue()); 
                Cat = currentCell.getStringCellValue();
                //tut.setCategoriaPregunta(currentCell.getStringCellValue());
                System.out.println("1: " + currentCell.getStringCellValue());
                break;
               // System.out.println(tt.findByindicaid("EFICACIA").get().getId());
              case 1:
              //tut.setIdPregunta((String) currentCell.getStringCellValue());
                String parts[] = currentCell.getStringCellValue().split("-");
                //String parts[] = tut.getIdPregunta().split("-");
                System.out.println("2: " + parts.length);

                for(int i=0;i<parts.length;i++){
                    
                    BenchmarkingIndica tut = new BenchmarkingIndica();
                    //List<PreguntasModeloB> def = prePregunRepository.findByIndicaid(Cat);
                   // defs.add((PreguntasModeloB) def);
                    tut.setCategoriaPregunta(Cat);
                    //System.out.println("ee: "+ Cat);
                    tut.setIdPregunta(parts[i]);
                    tut.setIdDef(e);
                    tutorials.add(tut);
                    
                    
                }



                break;
    
              default:
             // tut.setIdPregunta((String) currentCell.getStringCellValue());
             // System.out.println("3: " + currentCell.getStringCellValue());
                break;
              }
    
              cellIdx++;
            }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
            
    
            e++;
                


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////        
          }    
          //workbook.close();    
          return tutorials;
        } catch (IOException e) {
          throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
        }
      }
}
