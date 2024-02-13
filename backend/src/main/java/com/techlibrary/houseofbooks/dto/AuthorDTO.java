package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Author;

public class AuthorDTO {

    private Long id;
    private String name;
    private String biography;

    public AuthorDTO() {
    }

    public AuthorDTO(Author entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.biography = entity.getBiography();
    }

    public AuthorDTO(Long id, String name, String biography) {
        this.id = id;
        this.name = name;
        this.biography = biography;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }
}
