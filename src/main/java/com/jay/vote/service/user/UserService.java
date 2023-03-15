package com.jay.vote.service.user;

import com.jay.vote.dto.user.CreateUserRequest;
import com.jay.vote.dto.user.UserDto;
import com.jay.vote.dto.user.UserResponse;
import com.jay.vote.model.user.User;
import com.jay.vote.repo.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

    public UserResponse createUser(CreateUserRequest request) {
        User user = modelMapper.map(request, User.class);
        user.setCreateUserId(-1L);
        user.setEditUserId(-1L);
        userRepository.save(user);
        return new UserResponse(modelMapper.map(user, UserDto.class));
    }
}
