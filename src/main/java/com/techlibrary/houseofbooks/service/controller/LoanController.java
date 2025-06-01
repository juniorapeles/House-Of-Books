package com.techlibrary.houseofbooks.service.controller;

import com.techlibrary.houseofbooks.datasource.def.loan.CreateLoanUseCase;
import com.techlibrary.houseofbooks.datasource.def.loan.SearchLoanUseCase;
import com.techlibrary.houseofbooks.service.messaging.def.CreateMessageUseCase;
import com.techlibrary.houseofbooks.service.messaging.def.SearchMessageLoanUseCase;
import com.techlibrary.houseofbooks.service.dto.LoanDTO;
import com.techlibrary.houseofbooks.service.mapper.LoanMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/emprestimos")
public class LoanController {

    CreateLoanUseCase createLoanUseCase;
    CreateMessageUseCase createMessageUseCase;
    SearchMessageLoanUseCase searchMessageLoanUseCase;
    SearchLoanUseCase searchLoanUseCase;
    LoanMapper loanMapper;

    public LoanController(CreateLoanUseCase createLoanUseCase, CreateMessageUseCase createMessageUseCase,
                          SearchMessageLoanUseCase searchMessageLoanUseCase,
                          SearchLoanUseCase searchLoanUseCase, LoanMapper loanMapper) {
        this.createLoanUseCase = createLoanUseCase;
        this.createMessageUseCase = createMessageUseCase;
        this.searchMessageLoanUseCase = searchMessageLoanUseCase;
        this.searchLoanUseCase = searchLoanUseCase;
        this.loanMapper = loanMapper;
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Loan createLoan(@RequestBody LoanDTO loan) {
//        return createLoanUseCase.execute(loanMapper.map(loan));
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createLoan(@RequestBody LoanDTO loanDTO) {
         createLoanUseCase.execute(loanDTO);
        return "Empréstimo Criado na Base do REDIS";
    }

    @PostMapping("/message")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMessageLoan(@RequestBody LoanDTO loan) {
        createMessageUseCase.execute(loan);
        return "O Empréstimo vai ser analisado";
    }

    @GetMapping("/message")
    @ResponseStatus(HttpStatus.OK)
    public List<LoanDTO> getLoanMessages() {
        return searchMessageLoanUseCase.execute();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<LoanDTO> getLoans() {
        return searchLoanUseCase.execute();
    }
}