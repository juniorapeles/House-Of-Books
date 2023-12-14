package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.CategorieDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "tb_categories")
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "the 'name' field cannot be blank")
    private String name;
    @Column(columnDefinition = "TEXT")
    @NotBlank(message = "the 'description' field cannot be blank")
    private String description;

    public Categorie() {
    }

    public Categorie(CategorieDTO categorieDTO) {
        this.id = categorieDTO.getId();
        this.name = categorieDTO.getName();
        this.description = categorieDTO.getDeascription();
    }

    public Categorie(Long id, String name, String deascription) {
        this.id = id;
        this.name = name;
        this.description = deascription;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
