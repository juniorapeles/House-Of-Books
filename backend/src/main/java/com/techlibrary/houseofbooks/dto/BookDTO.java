package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;


public class BookDTO {

    private Long id;
    private Boolean borrowed;
    private String name;
    private Author author;

    private String description;

    public BookDTO() {
    }

    public BookDTO(Boolean borrowed, String name, Author author, String description) {
        this.borrowed = borrowed;
        this.name = name;
        this.author = author;
        this.description = description;
    }

    public BookDTO(Book entity) {
        this.id = entity.getId();
        this.borrowed = entity.getBorrowed();
        this.name = entity.getName();
        this.author = entity.getAuthor();
        this.description = entity.getDescription();
    }

    public Boolean getBorrowed() {
        return borrowed;
    }

    public void setBorrowed(Boolean borrowed) {
        this.borrowed = borrowed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }
}
