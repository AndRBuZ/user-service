package com.foodorder.user_service.service;

import com.foodorder.user_service.dto.request.UserRegistrationDto;
import com.foodorder.user_service.dto.response.UserCredentialsDto;
import com.foodorder.user_service.dto.response.UserPublicDto;
import com.foodorder.user_service.entity.User;
import com.foodorder.user_service.exception.UserNotFoundException;
import com.foodorder.user_service.mapper.UserMapper;
import com.foodorder.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserPublicDto createUser(UserRegistrationDto dto) {
        User user = new User(dto.getName(), dto.getEmail(), dto.getPassword());
        userRepository.save(user);
        return new UserPublicDto(user.getId(), user.getName(), user.getEmail());
    }

    public UserPublicDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return userMapper.toPublic(user);
    }

    public UserCredentialsDto getUserCredentialsByEmail (String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(UserNotFoundException::new);
        return userMapper.toCredentials(user);
    }
}
