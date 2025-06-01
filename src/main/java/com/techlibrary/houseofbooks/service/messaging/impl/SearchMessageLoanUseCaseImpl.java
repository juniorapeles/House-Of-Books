package com.techlibrary.houseofbooks.service.messaging.impl;

import com.techlibrary.houseofbooks.service.messaging.conumer.LoanConsumer;
import com.techlibrary.houseofbooks.service.messaging.def.SearchMessageLoanUseCase;
import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchMessageLoanUseCaseImpl implements SearchMessageLoanUseCase {

    LoanConsumer loanConsumer;

    public SearchMessageLoanUseCaseImpl(LoanConsumer loanConsumer) {
        this.loanConsumer = loanConsumer;
    }

    @Override
    public List<LoanDTO> execute() {
        return loanConsumer.getLoanMessages();
    }
}
