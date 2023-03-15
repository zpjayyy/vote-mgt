package com.jay.vote.service.user;

import com.google.common.hash.Hashing;
import com.jay.vote.api.BaseResponse;
import com.jay.vote.dto.user.*;
import com.jay.vote.error.ServiceException;
import com.jay.vote.model.user.User;
import com.jay.vote.repo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserResponse createUser(CreateUserRequest request) {
        checkPhoneOrEmailExist(request);

        User user = modelMapper.map(request, User.class);
        user.setPasswordHash(Hashing.hmacSha256("123".getBytes(StandardCharsets.UTF_8))
                .hashString(request.getPassword(), StandardCharsets.UTF_8).toString());
        user.setCreateUserId(-1L);
        user.setEditUserId(-1L);
        userRepository.save(user);
        return new UserResponse(modelMapper.map(user, UserDto.class));
    }

    private void checkPhoneOrEmailExist(CreateUserRequest request) {
        Optional.ofNullable(userRepository.findByPhoneNumberOrEmail(request.getPhoneNumber(), request.getEmail()))
                .orElseThrow(() -> new ServiceException("phone or email exist"));
    }

    public UserResponse login(LoginRequest request) {
        String passwordHash = Hashing.hmacSha256("123".getBytes(StandardCharsets.UTF_8))
                .hashString(request.getPassword(), StandardCharsets.UTF_8).toString();

        User user = Optional.ofNullable(userRepository.findByNameAndPasswordHash(request.getName(), passwordHash))
                .orElseThrow(() -> new ServiceException("user not exist or invalid password"));
        return new UserResponse(modelMapper.map(user, UserDto.class));
    }

    public UserResponse detail() {
        User user = userRepository.findById(null).orElseThrow(() -> new ServiceException("user exist"));
        return new UserResponse(modelMapper.map(user, UserDto.class));
    }

    public BaseResponse updatePassword(UpdatePasswordRequest request) {
        return BaseResponse.builder().build();
    }

    public BaseResponse update(UpdateRequest request) {
        return BaseResponse.builder().build();
    }
}
