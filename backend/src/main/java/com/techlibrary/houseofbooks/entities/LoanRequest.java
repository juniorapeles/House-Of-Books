package com.techlibrary.houseofbooks.entities;

import jakarta.validation.constraints.NotNull;

public class LoanRequest {
    @NotNull(message = "The 'idBook' field cannot be null")
    private Long idBook;
    @NotNull(message = "The 'idUser' field cannot be null")
    private Long idUser;

    public LoanRequest() {
    }

    public LoanRequest(Long idBook, Long idUser) {
        this.idBook = idBook;
        this.idUser = idUser;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
}
