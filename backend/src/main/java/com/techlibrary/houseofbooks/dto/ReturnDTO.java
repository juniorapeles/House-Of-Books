package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Book;

import java.util.List;

public class ReturnDTO {

    private Long loanId;
    private List<Book> returnedBooks;

    public ReturnDTO() {
    }

    public ReturnDTO(Long loanId, List<Book> returnedBooks) {
        this.loanId = loanId;
        this.returnedBooks = returnedBooks;
    }

    public Long getLoanId() {
        return loanId;
    }

    public void setLoanId(Long loanId) {
        this.loanId = loanId;
    }

    public List<Book> getReturnedBooks() {
        return returnedBooks;
    }

    public void setReturnedBooks(List<Book> returnedBooks) {
        this.returnedBooks = returnedBooks;
    }
}
