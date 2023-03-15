package com.jay.vote.controller.user;

import com.jay.vote.dto.user.CreateUserRequest;
import com.jay.vote.dto.user.UserResponse;
import com.jay.vote.service.user.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Setter(onMethod_ = @Autowired)
    private UserService userService;

    @PostMapping("/create")
    public UserResponse createUser(@Validated @RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

}
