package com.techlibrary.houseofbooks.datasource.impl.loan;

import com.techlibrary.houseofbooks.service.cache.LoanRedisService;
import com.techlibrary.houseofbooks.datasource.def.loan.CreateLoanUseCase;
import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import org.springframework.stereotype.Service;

@Service
public class CreateLoanRedisUseCaseImpl implements CreateLoanUseCase {

    private final LoanRedisService loanRedisService;

    public CreateLoanRedisUseCaseImpl(LoanRedisService loanRedisService) {
        this.loanRedisService = loanRedisService;
    }

    @Override
    public void execute(LoanDTO dto) {

        loanRedisService.saveLoan(dto);
    }

    public void get() {
        loanRedisService.getAllPendingLoans();
    }
}
