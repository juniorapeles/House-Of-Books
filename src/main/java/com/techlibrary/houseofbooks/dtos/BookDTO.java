package com.techlibrary.houseofbooks.dtos;

import com.techlibrary.houseofbooks.entities.Book;

public record BookDTO(Long id, String name, String authorName, String description, Boolean borrowed) {
    public BookDTO(Book book) {
        this(book.getId(), book.getName(), book.getAuthor().getName(), book.getDescription(), book.getBorrowed());
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public String authorName() {
        return authorName;
    }

    @Override
    public String description() {
        return description;
    }

    @Override
    public Boolean borrowed() {
        return borrowed;
    }
}