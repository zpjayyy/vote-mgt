package com.jay.vote.dto.user;

import com.jay.vote.validation.PhoneNumber;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CreateUserRequest {

    @Size(max = 100, message = "name length could not more than {max}")
    @NotBlank(message = "please input name")
    private String name;

    @Email(message = "invalid email")
    private String email;

    @PhoneNumber
    private String phoneNumber;
}
