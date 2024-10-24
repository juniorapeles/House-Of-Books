package com.techlibrary.houseofbooks.controllers;


import com.techlibrary.houseofbooks.dtos.LoanDTO;
import com.techlibrary.houseofbooks.services.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/loan")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping
    public ResponseEntity<Page<LoanDTO>> findAllPaged(Pageable pageable) {
        Page<LoanDTO> list = loanService.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<LoanDTO> findById(@PathVariable Long id) {
        LoanDTO dto = loanService.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<LoanDTO> insertLoan(@RequestBody LoanDTO dto) {
        dto = loanService.insertLoan(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.id()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LoanDTO> returnBook(@PathVariable Long id) {
        loanService.returnBook(id);
        return ResponseEntity.noContent().build();
    }
}
