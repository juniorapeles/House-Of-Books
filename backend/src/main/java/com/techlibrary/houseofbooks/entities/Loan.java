package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.LoanDTO;
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
