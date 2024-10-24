package com.techlibrary.houseofbooks.dtos;

import com.techlibrary.houseofbooks.entities.Loan;

public record LoanDTO(Long id, Long idBook, Long idUser) {
    public LoanDTO(Loan loan) {
        this(loan.getId(), loan.getBook().getId(), loan.getId());
    }
}