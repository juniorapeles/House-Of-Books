package com.techlibrary.houseofbooks.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
    @Autowired
    private LoanService loanService;

    @PostMapping("/borrow")
    public ResponceEntity<LoanDTO> borrowBook(@RequestBody LoanRequestDTO loanRequestDTO){
        if(loanService.isBookAvailableForBorrow(loanRequestDTO.getDTO.getBookId())){
            loanDTO loan = loanService.borrow(loanRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(loan);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
