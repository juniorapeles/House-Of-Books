package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Address;

public class AddressDTO {

    private Long id;

    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;

    public AddressDTO() {
    }

    public AddressDTO(Address add) {
        this.id = add.getId();
        this.street = add.getStreet();
        this.city = add.getCity();
        this.state = add.getState();    
        this.postalCode = add.getPostalCode();
        this.country = add.getCountry();
    }

    public AddressDTO(Long id, String street, String city, String state, String postalCode, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.country = country;
    }

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
