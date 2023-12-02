package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Loan;
import com.techlibrary.houseofbooks.entities.LoanRequest;
import com.techlibrary.houseofbooks.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    private LoanService service;

    @GetMapping
    public List<Loan>GetAllBorrowBooks() {
            return service.GetAllBorrowBooks();
    }
    @PostMapping
    public Loan borrowBook(@RequestBody LoanRequest loan) {
        Long bookId = loan.getIdBook();
        Long userId = loan.getIdUser();
        return service.BorrowBook(bookId, userId);
    }
}
