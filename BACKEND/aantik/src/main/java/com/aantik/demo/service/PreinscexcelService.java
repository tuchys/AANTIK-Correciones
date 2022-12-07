package com.aantik.demo.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.aantik.demo.HelperClassServices.AddUsers;
import com.aantik.demo.HelperClassServices.UserG;
import com.aantik.demo.HelperClassServices.UserRepository;
import com.aantik.demo.entidad.Estudiante;
import com.aantik.demo.entidad.PreguntasModeloB;
import com.aantik.demo.repositorio.EstudianteRepositorio;
import com.aantik.demo.repositorio.PreguntasRepository;

@Service
public class PreinscexcelService {
    
    @Autowired
    AddUsers addUsers;

    @Autowired
    EstudianteRepositorio estudrepo;

    @Autowired
    UserRepository usuarioAAntik;

    public void save(MultipartFile file) {
        try {
          List<Estudiante> tutorials = PreinscExcelReader.excelToTutorials(file.getInputStream());
          for(int i=0;i<tutorials.size();i++){
            if(!usuarioAAntik.existsByUsername(tutorials.get(i).getCorreo())){
                addUsers.addPreinsc(tutorials.get(i).getCorreo());
                UserG recien = usuarioAAntik.findByUsername(tutorials.get(i).getCorreo()).get();
                tutorials.get(i).setUserId(recien.getId());
                tutorials.get(i).setStatus(0);
                estudrepo.save(tutorials.get(i));
            }else{
                System.out.println(" El usuario con el correo " +tutorials.get(i).getCorreo() +" ya se encuentra registrado" );
            }
           
          }
          
        } catch (IOException e) {
          throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
      }

}
