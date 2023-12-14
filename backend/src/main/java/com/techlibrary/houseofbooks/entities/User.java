package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.UserDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "the 'name' field cannot be blank")
    private String name;

    @NotBlank(message = "The 'Rg' field cannot be blank")
    @Size(min = 9, max = 14, message = "The 'rg' field must have between 9 and 14 characters")
    private String Rg;
    @NotBlank(message = "The 'Rg' field cannot be blank")
    @Email(message = "Please provide a valid email address")
    private String email;
    @NotBlank(message = "The 'telephone' field cannot be blank")
    @Pattern(regexp = "\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}", message = "Please provide a valid telephone number")
    private String telephone;
    @OneToOne
    @JoinColumn(name = "address_id")
    @NotNull(message = "The 'address_id' field cannot be null")
    private Address address;

    public User() {
    }

    public User(UserDTO userDTO) {
        this.id = userDTO.getId();
        this.name = userDTO.getName();
        Rg = userDTO.getRg();
        this.email = userDTO.getEmail();
        this.telephone = userDTO.getTelephone();
        this.address = userDTO.getAddress();
    }

    public User(Long id, String name, String rg, String email, String telephone, Address address) {
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
