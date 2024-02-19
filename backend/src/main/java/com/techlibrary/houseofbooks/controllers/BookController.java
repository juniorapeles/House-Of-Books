package com.techlibrary.houseofbooks.controllers;


import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<Page<BookDTO>> FindAll(Pageable pageable){
        Page<BookDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> FindById(@PathVariable  Long id){
        BookDTO dto = service.FindById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<BookDTO> insertBook(@RequestBody BookDTO dto){
        dto = service.insertBook(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getName()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> UpdateBook(@PathVariable Long id, @RequestBody BookDTO dto){
        dto = service.UpdateBook(id, dto);
        return ResponseEntity.ok().body(dto);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookDTO> DeleteBook(@PathVariable Long id) {
        service.DeleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
