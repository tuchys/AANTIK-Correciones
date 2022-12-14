package com.aantik.demo.Services;

import com.aantik.demo.model.EmailDetails;

public interface EmailService {
    
    String sendSimpleMail(EmailDetails details);
 
    // Method
    // To send an email with attachment
    String sendMailWithAttachment(String email,String token);

    // Method
    // To send an email with user details
    String sendMailForUsers(String email,String Password);
    

}
