package com.techlibrary.houseofbooks.service.enums;


public enum UserRole {

    ADMIN("admin"),
    USER("id_user");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }


}
