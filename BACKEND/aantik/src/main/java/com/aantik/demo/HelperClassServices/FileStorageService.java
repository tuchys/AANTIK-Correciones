package com.aantik.demo.HelperClassServices;
import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.HelperClassServices.FileSt;
import com.aantik.demo.HelperClassServices.FileStRepo;

@Service
public class FileStorageService {
    
    @Autowired
    private FileStRepo fileDBRepository;

    public FileSt store(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileSt FileDB = new FileSt(fileName, file.getContentType(), file.getBytes());
    
        return fileDBRepository.save(FileDB);
      }
    
      public FileSt getFile(String id) {
        return fileDBRepository.findById(id).get();
      }
      
      public Stream<FileSt> getAllFiles() {
        return fileDBRepository.findAll().stream();
      }


}
