package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Book;

public class BookDTO {

    private String name;
    private String authorName;
    private String description;

    public BookDTO() {
    }

    public BookDTO(String name, String author, String description) {
        this.name = name;
        this.authorName = author;
        this.description = description;
    }

    public BookDTO(Book book) {
        this.name = book.getName();
        this.authorName = book.getAuthor().getName();
        this.description = book.getDescription();
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
}
