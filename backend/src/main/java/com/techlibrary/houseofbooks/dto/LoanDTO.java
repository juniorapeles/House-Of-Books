package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.entities.Loan;
import com.techlibrary.houseofbooks.entities.User;

public class LoanDTO {

    private Long id;
    private Book book_id;
    private User user_id;


    public LoanDTO() {
    }

    public LoanDTO(Long id, Book book_id, User user_id) {
        this.id = id;
        this.book_id = book_id;
        this.user_id = user_id;
    }

    public LoanDTO(Loan entity) {
        this.id = entity.getId();
        this.book_id = entity.getBook_id();
        this.user_id = entity.getUser_id();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Book getBook_id() {
        return book_id;
    }

    public void setBook_id(Book book_id) {
        this.book_id = book_id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }
}
