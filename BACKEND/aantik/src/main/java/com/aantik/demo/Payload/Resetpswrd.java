package com.aantik.demo.Payload;
import javax.validation.constraints.NotBlank;
public class Resetpswrd {

    @NotBlank
    private String password;
    private String passwordConfirm;
    private String token;
    
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    

  }
