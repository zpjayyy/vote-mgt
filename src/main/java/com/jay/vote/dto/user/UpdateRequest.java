package com.jay.vote.dto.user;

import com.jay.vote.validation.PhoneNumber;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UpdateRequest {

    @Email(message = "invalid email")
    @NotBlank(message = "please input email")
    private String email;

    @PhoneNumber
    @NotBlank(message = "please input phone number")
    private String phoneNumber;

}
