package com.aantik.demo.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.aantik.demo.entidad.PreguntasModeloB;
import com.aantik.demo.repositorio.PreguntasRepository;


@Service
public class PreguntaExcelService {
    
    @Autowired
    PreguntasRepository repository;

    public void save(MultipartFile file) {
        try {
          List<PreguntasModeloB> tutorials = PreguntasExcelReader.excelToTutorials(file.getInputStream());
          repository.saveAll(tutorials);
        } catch (IOException e) {
          throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
      }
    
      public List<PreguntasModeloB> getAllTutorials() {
        return repository.findAll();
      }
}
