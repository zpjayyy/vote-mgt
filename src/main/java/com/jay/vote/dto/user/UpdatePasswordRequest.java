package com.jay.vote.dto.user;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdatePasswordRequest {

    @Size(max = 20, message = "password length could not more than {max}")
    @NotBlank(message = "please input password")
    private String oldPassword;

    @Size(max = 20, message = "password length could not more than {max}")
    @NotBlank(message = "please input password")
    private String newPassword;

}
