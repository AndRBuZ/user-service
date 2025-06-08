package com.foodorder.user_service.dto.request;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class UserRegistrationDto {
    @NotBlank
    private String name;

    @NotBlank
    @Email(message = "Please provide a valid email address", regexp = ".+@.+\\..+")
    @Column(unique = true)
    private String email;

    @Size(min = 6)
    private String password;
}
