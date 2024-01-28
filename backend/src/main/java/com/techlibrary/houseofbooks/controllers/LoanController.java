//package com.techlibrary.houseofbooks.controllers;
//
//import com.techlibrary.houseofbooks.entities.LoanRequest;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/loan")
//public class LoanController {
//
//    @Autowired
//    private LoanService service;
//
//    @GetMapping
//    public List<Loan> GetAllBorrowBooks() {
//        return service.GetAllBorrowBooks();
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<LoanDTO> GetBorrowBooksById(@PathVariable Long id) {
//        LoanDTO loanDTO = service.GetBorrowBookById(id);
//
//        if (loanDTO != null) {
//            return ResponseEntity.ok(loanDTO);
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//
//    @PostMapping
//    public ResponseEntity<LoanDTO> BorrowBook(@RequestBody LoanRequest loan) {
//        Long bookId = loan.getIdBook();
//        Long userId = loan.getIdUser();
//        LoanDTO loanCreated = service.BorrowBook(bookId, userId);
//        return ResponseEntity.status(HttpStatus.CREATED).body(loanCreated);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<LoanDTO> returnBook(@PathVariable Long idLoan) {
//        LoanDTO loanUpdated = service.returnBook(idLoan);
//        return ResponseEntity.status(HttpStatus.OK).body(loanUpdated);
//    }
//
//}
