//package com.techlibrary.houseofbooks.datasource.impl;
//
//import com.techlibrary.houseofbooks.service.cache.LoanRedisService;
//import com.techlibrary.houseofbooks.datasource.def.loan.CreateLoanUseCase;
//import com.techlibrary.houseofbooks.domain.model.loan.Loan;
//import com.techlibrary.houseofbooks.service.base.loan.LoanRepositoryJpa;
//import org.springframework.stereotype.Service;
//
//@Service
//public class CreateLoanUseCaseImpl implements CreateLoanUseCase {
//
//    private final LoanRepositoryJpa loanRepository;
//
//    public CreateLoanUseCaseImpl(LoanRepositoryJpa loanRepository) {
//        this.loanRepository = loanRepository;
//    }
//
//    @Override
//    public Loan execute(Loan loan) {
//        return loanRepository.save(loan);
//    }
//}
