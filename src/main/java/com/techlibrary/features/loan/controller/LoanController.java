package com.techlibrary.features.loan.controller;

import com.techlibrary.generics.GenericController;
import com.techlibrary.features.loan.dto.LoanDTO;
import com.techlibrary.generics.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("loans")
public class LoanController extends GenericController<LoanDTO, Long> {

    public LoanController(GenericService<LoanDTO, Long> service) {
        super(service);
    }

}