package com.techlibrary.features.loan.service;

import com.techlibrary.features.loan.dto.LoanDTO;
import com.techlibrary.features.loan.domain.Loan;
import com.techlibrary.features.loan.mapper.LoanMapper;
import com.techlibrary.generics.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService extends GenericServiceImpl<Loan, LoanDTO, Long, LoanMapper> {

    public LoanService(JpaRepository<Loan, Long> repository, LoanMapper mapper) {
        super(repository, mapper);
    }

}