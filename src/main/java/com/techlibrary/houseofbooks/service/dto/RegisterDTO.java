package com.techlibrary.houseofbooks.service.dto;

import com.techlibrary.houseofbooks.service.enums.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
