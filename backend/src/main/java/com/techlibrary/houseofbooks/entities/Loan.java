package com.techlibrary.houseofbooks.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Book book;
    @OneToOne
    @JoinColumn(name = "book_id")
    private User user;

    public Loan() {
    }

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
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
