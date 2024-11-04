package com.example.realestate.dtos.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SignInRequest implements Serializable {
    @NotBlank(message = "username must be not null")
    private String username;
    @NotBlank(message = "username must be not blank")
    private String password;
}
