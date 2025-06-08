package com.techlibrary.features.loan.controller;

import com.techlibrary.features.loan.service.LoanService;
import com.techlibrary.generics.GenericController;
import com.techlibrary.features.loan.dto.LoanDTO;
import com.techlibrary.generics.GenericService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loans")
public class LoanController extends GenericController<LoanDTO, Long> {

    private final LoanService loanService;

    public LoanController(GenericService<LoanDTO, Long> service, LoanService loanService) {
        super(service);
        this.loanService = loanService;
    }

    @PutMapping("/return/{id}")
    public LoanDTO returnLoan(@PathVariable Long id) {
        return loanService.returnLoan(id);
    }

}