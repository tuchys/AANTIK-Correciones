package com.aantik.demo.control;


import java.io.UnsupportedEncodingException;

//import javax.validation.Valid;

import org.apache.logging.log4j.message.StringFormattedMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.util.MultiValueMap;

import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;

import com.aantik.demo.model.actualizarDatosPre;

@CrossOrigin(origins = "*", maxAge = 3600)

@RestController

//RequestMapping("/datos")

public class PreController {
    @PostMapping("/datosPre")
    public ResponseEntity<?> processForgotPassword(@RequestBody actualizarDatosPre update) {

    System.out.println("Tel: " + update.getTelefono());

    System.out.println("Localidad: " + update.getNotif());
    return ResponseEntity.ok("ok");
    }
    


}
