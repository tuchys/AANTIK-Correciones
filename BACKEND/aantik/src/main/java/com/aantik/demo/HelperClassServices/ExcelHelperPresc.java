package com.aantik.demo.HelperClassServices;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelperPresc {
  
    @Autowired
    static
    UserRepository userRepository;


    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    static String[] HEADERs = { "Correo" };
    static String SHEET = "Preinsc";
  
    public static boolean hasExcelFormat(MultipartFile file) {
  
      if (!TYPE.equals(file.getContentType())) {
        return false;
      }
  
      return true;
    }
  
    public static List<UserG> excelToTutorials(InputStream is) {

      try {
        Workbook workbook = new XSSFWorkbook(is);
  
        Sheet sheet = workbook.getSheet(SHEET);
        Iterator<Row> rows = sheet.iterator();
        
        List<UserG> tutorials = new ArrayList<UserG>();
  
        int rowNumber = 0;
        while (rows.hasNext()) {
          Row currentRow = rows.next();
  
          // skip header
          if (rowNumber == 0) {
            rowNumber++;
            continue;
          }
  
          Iterator<Cell> cellsInRow = currentRow.iterator();
          
          UserG tutorial = new UserG();
          
          int cellIdx = 0;
          while (cellsInRow.hasNext()) {
            Cell currentCell = cellsInRow.next();
  
            switch (cellIdx) {
            case 0:
            tutorial.setUsername(currentCell.getStringCellValue());
            if (userRepository.existsByUsername(tutorial.getUsername())) {
                  break;
            }
              
              tutorial.setPassword("Aantik2020");
              break;
  
            default:
              break;
            }
  
           // cellIdx++;
          }
  
          tutorials.add(tutorial);
        }
  
        workbook.close();
  
        return tutorials;
      } catch (IOException e) {
        throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
      }
    }
}
