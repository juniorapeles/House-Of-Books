package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Loan;

public class LoanDTO {

    private Long id;
    private Long bookId;
    private Long userId;

    public LoanDTO() {
    }

    public LoanDTO(Long id, Long bookId, Long userId) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
    }

    public LoanDTO(Loan loan) {
        this.id = loan.getId();
        this.bookId = (loan.getBook() != null) ? loan.getBook().getId() : null;
        this.userId = (loan.getUser() != null) ? loan.getUser().getId() : null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
