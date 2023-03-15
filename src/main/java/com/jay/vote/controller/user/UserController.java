package com.jay.vote.controller.user;

import com.jay.vote.api.BaseResponse;
import com.jay.vote.dto.user.*;
import com.jay.vote.service.user.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Setter(onMethod_ = @Autowired)
    private UserService userService;

    @PostMapping("/create")
    public UserResponse createUser(@Validated @RequestBody CreateUserRequest request) {
        return userService.createUser(request);
    }

    @PostMapping("/login")
    public UserResponse login(@Validated @RequestBody LoginRequest request) {
        return userService.login(request);
    }

    @PutMapping("/update_password")
    public BaseResponse updatePassword(@Validated @RequestBody UpdatePasswordRequest request) {
        return userService.updatePassword(request);
    }

    @PutMapping("/update")
    public BaseResponse update(@Validated @RequestBody UpdateRequest request) {
        return userService.update(request);
    }

    @GetMapping("/detail")
    public UserResponse detail() {
        return userService.detail();
    }
}
