package com.techlibrary.houseofbooks.controllers;


import com.techlibrary.houseofbooks.dto.LoanDTO;
import com.techlibrary.houseofbooks.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/loan")
public class LoanController {

    private final LoanService service;

    @Autowired
    public LoanController(final LoanService service) {
        this.service = service;
    }

    //retorno

//    @GetMapping
//    public ResponseEntity<Page<BookDTO>> FindAll(
//            @RequestParam(value = "page", defaultValue = "0") Integer page,
//            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
//            @RequestParam(value = "direction", defaultValue = "DESC") String direction,
//            @RequestParam(value = "orderBy", defaultValue = "name") String orderBy
//            ){
//
//        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(direction), orderBy);
//
//        Page<BookDTO> list = service.findAllPaged(pageRequest);
//        return ResponseEntity.ok().body(list);
//    }
//
//
//    @GetMapping(value = "/{id}")
//    public ResponseEntity<BookDTO> FindById(@PathVariable  Long id){
//        BookDTO dto = service.FindById(id);
//        return ResponseEntity.ok().body(dto);
//    }

    @PostMapping
    public ResponseEntity<LoanDTO> insertLoan(@RequestBody LoanDTO dto){
        dto = service.insertLoan(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

//    @PutMapping(value = "/{id}")
//    public ResponseEntity<BookDTO> UpdateBook(@PathVariable Long id, @RequestBody BookDTO dto){
//        dto = service.UpdateBook(id, dto);
//        return ResponseEntity.ok().body(dto);
//    }
//
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<LoanDTO> returnBook(@PathVariable Long id) {
        service.returnBook(id);
        return ResponseEntity.noContent().build();
    }
}
