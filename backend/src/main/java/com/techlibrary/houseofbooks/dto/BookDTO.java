package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;

import java.util.Date;


public class BookDTO {

    private Long id;
    private String name;
    private Author author;

    private Date publication_date;

    private String description;
    public BookDTO() {
    }

    public BookDTO(Long id, String name, Author author, Date publication_date, String description) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publication_date = publication_date;
        this.description = description;
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Date getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(Date publication_date) {
        this.publication_date = publication_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
