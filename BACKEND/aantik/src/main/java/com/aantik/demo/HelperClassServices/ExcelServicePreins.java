package com.aantik.demo.HelperClassServices;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.HelperClassServices.ExcelHelperPresc;
import com.aantik.demo.HelperClassServices.UserG;
import com.aantik.demo.HelperClassServices.UserRepository;

@Service
public class ExcelServicePreins {

  @Autowired
  UserRepository repository;

  public void save(MultipartFile file) {
    try {
      List<UserG> tutorials = ExcelHelperPresc.excelToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store excel data: " + e.getMessage());
    }
  }

  public List<UserG> getAllTutorials() {
    return repository.findAll();
  }
}