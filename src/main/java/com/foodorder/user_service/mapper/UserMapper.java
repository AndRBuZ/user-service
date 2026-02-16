package com.foodorder.user_service.mapper;

import com.foodorder.user_service.dto.response.UserCredentialsDto;
import com.foodorder.user_service.dto.response.UserPublicDto;
import com.foodorder.user_service.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserPublicDto toPublic(User user) {
        return new UserPublicDto(user.getId(), user.getName(), user.getEmail());
    }

    public UserCredentialsDto toCredentials(User user) {
        return new UserCredentialsDto(
                user.getId(),
                user.getEmail(),
                user.getName(),
                user.getPassword()
        );
    }
}
