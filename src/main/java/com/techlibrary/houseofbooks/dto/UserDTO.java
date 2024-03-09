package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.User;

public class UserDTO {

    private String name;

    public UserDTO() {
    }

    public UserDTO(String name) {
        this.name = name;
    }

    public UserDTO(User entity) {
        this.name = entity.getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
