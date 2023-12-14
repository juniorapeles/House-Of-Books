package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.AddressDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "tb_address")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "the 'street' field cannot be blank")
    private String street;
    @NotBlank(message = "the 'city' field cannot be blank")
    private String city;
    @NotBlank(message = "the 'state' field cannot be blank")
    private String state;
    @NotBlank(message = "the 'postal code' field cannot be blank")
    @Length(min = 5, max = 10, message = "the postal code must be between 5 and 10 characters")
    private String postalCode;
    @NotBlank(message = "the 'postal code' field cannot be blank")
    private String country;

    public Address() {
    }

    public Address(String street, String city, String state, String postalCode, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

    public Address(AddressDTO dto) {
        this.street = dto.getStreet();
        this.city = dto.getCity();
        this.state = dto.getState();
        this.postalCode = dto.getPostalCode();
        this.country = dto.getCountry();
    }

    // Getters e Setters para todos os campos:
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
