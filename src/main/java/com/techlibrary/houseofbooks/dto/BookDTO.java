package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Book;

public class BookDTO {

    private Long id;
    private String name;
    private String authorName;
    private String description;

    private Boolean borrowed;

    public BookDTO() {
    }

    public BookDTO(Long id,String name, String author, String description, Boolean borrowed) {
        this.id = id;
        this.name = name;
        this.authorName = author;
        this.description = description;
        this.borrowed = borrowed;
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.name = book.getName();
        this.authorName = book.getAuthor().getName();
        this.description = book.getDescription();
        this.borrowed = book.getBorrowed();
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

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBorrowed() {
        return borrowed;
    }
}
