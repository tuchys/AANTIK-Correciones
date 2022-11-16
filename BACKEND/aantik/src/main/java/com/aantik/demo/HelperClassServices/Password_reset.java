package com.aantik.demo.HelperClassServices;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Entity
@Table(	name = "PswrdReset")
public class Password_reset {
    @Id
    @NotBlank
    @Size(max = 10)
    private String Token;
    
    @Size(max = 50)
    @Email
    private String username;



    public Password_reset() {
    }

    public Password_reset(String username, String token) {
        this.username = username;
        this.Token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

}
