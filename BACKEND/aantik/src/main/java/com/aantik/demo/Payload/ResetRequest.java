package com.aantik.demo.Payload;

import javax.validation.constraints.NotBlank;

public class ResetRequest {
  @NotBlank
  private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

