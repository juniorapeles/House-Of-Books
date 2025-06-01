package com.techlibrary.houseofbooks.datasource.def.loan;

import com.techlibrary.houseofbooks.service.dto.LoanDTO;

import java.util.List;

public interface SearchLoanUseCase {
    List<LoanDTO> execute();
}
