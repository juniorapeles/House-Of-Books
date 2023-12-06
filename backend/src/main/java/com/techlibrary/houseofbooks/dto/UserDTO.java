package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Address;
import com.techlibrary.houseofbooks.entities.User;
import jakarta.persistence.*;

public class UserDTO {

    private Long id;
    private String name;
    private String Rg;
    private String email;
    private String telephone;

    private Address address;

    public UserDTO() {
    }

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        Rg = user.getRg();
        this.email = user.getEmail();
        this.telephone = user.getTelephone();
        this.address = user.getAddress();
    }

    public UserDTO(Long id, String name, String rg, String email, String telephone, Address address) {
        this.id = id;
        this.name = name;
        Rg = rg;
        this.email = email;
        this.telephone = telephone;
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return Rg;
    }

    public void setRg(String rg) {
        Rg = rg;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
