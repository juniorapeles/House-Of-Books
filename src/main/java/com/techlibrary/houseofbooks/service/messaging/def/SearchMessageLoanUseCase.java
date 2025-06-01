package com.techlibrary.houseofbooks.service.messaging.def;

import com.techlibrary.houseofbooks.service.dto.LoanDTO;

import java.util.List;

public interface SearchMessageLoanUseCase {
    List<LoanDTO> execute();
}
