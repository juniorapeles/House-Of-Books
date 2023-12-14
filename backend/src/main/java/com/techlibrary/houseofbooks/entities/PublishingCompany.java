package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.PublishingCompanyDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_PublishingCompany")
public class PublishingCompany {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "the 'name' field cannot be blank")
    private String name;

    public PublishingCompany() {
    }
    public PublishingCompany(PublishingCompanyDTO publishingCompanyDTO) {
        this.id = publishingCompanyDTO.getId();
        this.name = publishingCompanyDTO.getName();
    }
    public PublishingCompany(Long id, String name) {
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
