package com.techlibrary.houseofbooks.service.dto;

import com.techlibrary.houseofbooks.domain.book.Book;

public class BookDTO {

    private String title;
    private String author;
    private String isbn;

    public BookDTO() {
    }

    public BookDTO(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public BookDTO(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.isbn = book.getIsbn();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
