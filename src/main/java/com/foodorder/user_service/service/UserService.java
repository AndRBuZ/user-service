package com.foodorder.user_service.service;

import com.foodorder.user_service.dto.request.UserRegistrationDto;
import com.foodorder.user_service.dto.response.UserResponseDto;
import com.foodorder.user_service.entity.User;
import com.foodorder.user_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRegistrationDto dto) {
        User user = new User(dto.getName(), dto.getEmail(), dto.getPassword());
        userRepository.save(user);
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }

    public UserResponseDto getUserByEmail(String email) {
        User user = userRepository.getUsersByEmail(email);
        return new UserResponseDto(user.getId(), user.getName(), user.getEmail(), user.getPassword());
    }
}
