package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.LoanDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_loan")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "book_id")
    @NotNull(message = "the 'book' field cannot be null")
    private Book book;
    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "the 'user' field cannot be null")
    private User user;

    public Loan() {
    }

    public Loan(Book book, User user) {
        this.book = book;
        this.user = user;
    }

    public Loan(LoanDTO loanDTO) {
        this.id = loanDTO.getId();
        this.book = loanDTO.getBook();
        this.user = loanDTO.getUser();
    }

    public Loan(Long id, Book book, User user) {
        this.id = id;
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
