package com.foodorder.user_service.service;

import com.foodorder.user_service.dto.request.UserRegistrationDto;
import com.foodorder.user_service.dto.response.UserResponseDto;
import com.foodorder.user_service.entity.User;
import com.foodorder.user_service.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponseDto createUser(UserRegistrationDto dto) {
        String hashed = BCrypt.hashpw(dto.getPassword(), BCrypt.gensalt());
        User user = new User(dto.getName(), dto.getEmail(), hashed);
        userRepository.save(user);
        return new UserResponseDto(user.getId(), user.getName(),  user.getEmail());
    }
}
