package com.techlibrary.houseofbooks.domain.model.dto;

import com.techlibrary.houseofbooks.domain.model.user.enums.UserRole;

public record RegisterDTO(
        String login,
        String password,
        UserRole role
) {
}
