package com.techlibrary.houseofbooks.entities;

public class LoanRequest {
    private Long idBook;
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
