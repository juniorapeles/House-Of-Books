package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.PublishingCompany;



public class PublishingCompanyDTO {

    private Long id;
    private String name;

    public PublishingCompanyDTO() {
    }

    public PublishingCompanyDTO(PublishingCompany publishingCompany) {
        this.id = publishingCompany.getId();
        this.name = publishingCompany.getName();
    }

    public PublishingCompanyDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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
}
