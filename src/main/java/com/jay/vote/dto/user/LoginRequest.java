package com.jay.vote.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class LoginRequest {

    @Size(max = 100, message = "name length could not more than {max}")
    @NotBlank(message = "please input name")
    private String name;

    @Size(max = 20, message = "password length could not more than {max}")
    @NotBlank(message = "please input password")
    private String password;
}
