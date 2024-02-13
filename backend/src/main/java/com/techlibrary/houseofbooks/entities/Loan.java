package com.techlibrary.houseofbooks.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_LOAN")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book_id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    public Loan() {
    }

    public Loan(Long id, Book book_id, User user_id) {
        this.id = id;
        this.book_id = book_id;
        this.user_id = user_id;
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
