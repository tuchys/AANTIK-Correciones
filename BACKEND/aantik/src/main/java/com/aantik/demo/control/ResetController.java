package com.aantik.demo.control;

//import com.aantik.demo.model.EmailDetails;
import com.aantik.demo.Services.EmailService;

import java.util.List;

import javax.validation.Valid;

//import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import net.bytebuddy.utility.RandomString;
import com.aantik.demo.Payload.ResetRequest;
import com.aantik.demo.HelperClassServices.Password_reset;
import com.aantik.demo.HelperClassServices.PswrdRepo;
import com.aantik.demo.HelperClassServices.UserG;
import com.aantik.demo.HelperClassServices.UserRepository;
import com.aantik.demo.Payload.MessageResponse;
import com.aantik.demo.Payload.Resetpswrd;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user")
public class ResetController {

    @Autowired private EmailService emailService;

    @Autowired private UserRepository userRepository;

    @Autowired private PswrdRepo pswrdRepo;
    @Autowired
	PasswordEncoder encoder;

   // @Autowired private Password_reset passwordM;

    @PostMapping("/recuperaPswrd")
    public ResponseEntity<?> processForgotPassword(@Valid @RequestBody ResetRequest resetRequest) {
        System.out.println("Email: " + resetRequest.getEmail());
        if(userRepository.existsByUsername(resetRequest.getEmail())){
        String token = RandomString.make(10);
        System.out.println("Token" + token);

        Password_reset password_reset = new Password_reset(resetRequest.getEmail(), token);

        pswrdRepo.save(password_reset);

        String message = emailService.sendMailWithAttachment(resetRequest.getEmail(), token);
 
        return ResponseEntity.ok(new MessageResponse(message));
    }else{
        return ResponseEntity.ok(new MessageResponse("Usuario no existe en la bases de datos de AANTIK"));
    }
}
    @PostMapping("/reset")
    public ResponseEntity<?> ResetPassword(@Valid @RequestBody Resetpswrd resetRequest) {
            
        if(pswrdRepo.existsById(resetRequest.getToken())){

            Password_reset tutorial = pswrdRepo.findById(resetRequest.getToken()).get();

            UserG user = userRepository.findByUsername(tutorial.getUsername()).get();

            user.setPassword(encoder.encode(resetRequest.getPassword()));

            pswrdRepo.delete(tutorial);

            return ResponseEntity.ok(new MessageResponse("Contrasena cambiada"));
        }else{
            System.out.println("aquiii");
            return ResponseEntity.ok(new MessageResponse("Usuario no pidio, intente otra vez"));
        }

        }
    
}
