package com.techlibrary.houseofbooks.datasource.def.loan;

import com.techlibrary.houseofbooks.service.dto.LoanDTO;

public interface CreateLoanUseCase {
    void execute(LoanDTO loan);
    void get();
}
