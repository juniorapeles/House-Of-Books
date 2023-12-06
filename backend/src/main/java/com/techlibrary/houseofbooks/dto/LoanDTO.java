package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.entities.Loan;
import com.techlibrary.houseofbooks.entities.User;
import jakarta.persistence.*;


public class LoanDTO {
    private Long id;
    private Book book;
    private User user;

    public LoanDTO() {
    }
    public LoanDTO(Loan loan) {
        this.id = loan.getId();
        this.book = loan.getBook();
        this.user = loan.getUser();
    }
    public LoanDTO(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
