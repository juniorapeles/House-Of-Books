package com.techlibrary.houseofbooks.resources;

import com.techlibrary.houseofbooks.dto.LoanRequestDTO;
import com.techlibrary.houseofbooks.dto.LoanDTO;
import com.techlibrary.houseofbooks.dto.ReturnDTO;
import com.techlibrary.houseofbooks.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/borrow")
    public ResponseEntity<LoanDTO> borrowBook(@RequestBody LoanRequestDTO loanRequestDTO) {
        if (loanService.isBookAvailableForBorrow(loanRequestDTO.getBookId())) {
            LoanDTO loan = loanService.borrow(loanRequestDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(loan);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }

    @PostMapping("/return/{loanId}")
    public ResponseEntity<ReturnDTO> ReturnBook(@PathVariable Long loanId) {
        ReturnDTO returnDTO = loanService.returnBook(loanId);

        if (returnDTO != null) {
            return ResponseEntity.status(HttpStatus.OK).body(returnDTO);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
