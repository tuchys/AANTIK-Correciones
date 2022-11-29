package com.aantik.demo.control;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.aantik.demo.model.encuestaPre;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController

//RequestMapping("/datos")

public class encuestaPreController {
    @PostMapping("/encuesta")
    public ResponseEntity<?> processForgotPassword(@RequestBody encuestaPre update) {

    System.out.println("Tel: " + update.getTelefono());

    System.out.println("Localidad: " + update.getLocalidad());
    return ResponseEntity.ok("ok");
    }
    


}
