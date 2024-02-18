package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Loan;

public class LoanDTO {

    private Long id;
    private Long idBook;
    private Long idUser;

    public LoanDTO() {
    }

    public LoanDTO(Long idBook, Long idUser) {
        this.idBook = idBook;
        this.idUser = idUser;
    }

    public LoanDTO(Loan loan) {
        this.id = loan.getId();
        this.idBook = loan.getBook().getId();
        this.idUser = loan.getUser().getId();
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
