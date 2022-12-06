package com.aantik.demo.Services;

//import java.io.File;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.swing.event.PopupMenuListener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.core.io.FileSystemResource;
//import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.aantik.demo.model.EmailDetails;

@Service
public class EmailServiceImpl implements EmailService {
    
    @Autowired private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String mallFrom;

    @Override
    public String sendSimpleMail(EmailDetails details) {
        // Try block to check for exceptions
        return "Cool";
    }

    @Override
    public String sendMailWithAttachment(String email,String token) {
        // Creating a mime message
        MimeMessage mimeMessage
            = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;
 
        try {
 
            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                = new MimeMessageHelper(mimeMessage, false);
            
            mimeMessageHelper.setTo(email);
            String url="http://localhost:8081/#/user/reset/"+token;
            mimeMessageHelper.setText("Siga en el siguiente link para restablecer tu contraseña \n "+ url);
            mimeMessageHelper.setSubject("AANTIK restablecer contraseña");
 
            // Sending the mail
            javaMailSender.send(mimeMessage);
            System.out.print("Mail enviado");
            return "Email para reseteo de contraseña enviado con éxito para " + email;
        }
 
        // Catch block to handle MessagingException
        catch (MessagingException e) {
 
            // Display message when exception occurred
            System.out.print("Error while sending mail!!!");
            return "Error while sending mail!!!";
        }
    }

    @Override
    public String sendMailForUsers(String email, String Password){

    MimeMessage mimeMessage= javaMailSender.createMimeMessage();
    MimeMessageHelper mimeMessageHelper;

        try {

        // Setting multipart as true for attachments to
        // be send
        mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
        
        mimeMessageHelper.setTo(email);
        String url="http://localhost:8081/#/login2";
        mimeMessageHelper.setText("Hola bienvenido a AANTIK, \n a seguir se le brindara las credenciales para entrar a la aplicacion en el enlace " + url + " : \n Username: "+ email + "\n Contrasena: "+ Password);
        mimeMessageHelper.setSubject("AANTIK usuario");

        // Sending the mail
        javaMailSender.send(mimeMessage);
        System.out.print("Mail enviado");
        return "Email para registro de usuario enviado con éxito para " + email;
        }

// Catch block to handle MessagingException
        catch (MessagingException e) {

        // Display message when exception occurred
        System.out.print("Error while sending mail!!!");
        return "Error while sending mail!!!";
        }
    }
}

