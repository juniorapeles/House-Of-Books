package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Categorie;


public class CategorieDTO {
    private Long id;
    private String name;

    private String deascription;

    public CategorieDTO() {
    }
    public CategorieDTO(Categorie categorie) {
        this.id = categorie.getId();
        this.name = categorie.getName();
        this.deascription = categorie.getDescription();
    }
    public CategorieDTO(Long id, String name, String deascription) {
        this.id = id;
        this.name = name;
        this.deascription = deascription;
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

    public String getDeascription() {
        return deascription;
    }

    public void setDeascription(String deascription) {
        this.deascription = deascription;
    }
}
