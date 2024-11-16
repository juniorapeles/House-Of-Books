package com.techlibrary.houseofbooks.controllers;


import com.techlibrary.houseofbooks.dtos.BookDTO;
import com.techlibrary.houseofbooks.services.BookService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "*")
public class BookController {

    public BookController(BookService service) {
        this.service = service;
    }

    final BookService service;

    @GetMapping
    public ResponseEntity<Page<BookDTO>> findAllPaged(Pageable pageable) {
        Page<BookDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/available")
    public ResponseEntity<Page<BookDTO>> findAvailableBooks(Pageable pageable) {
        Page<BookDTO> list = service.findAvailableBooks(pageable);
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/borrowed")
    public ResponseEntity<Page<BookDTO>> findBooksUnavailable(Pageable pageable) {
        Page<BookDTO> list = service.findByBorrowedTrue(pageable);
        return ResponseEntity.ok().body(list);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> findById(@PathVariable Long id) {
        BookDTO dto = service.findById(id);
        return ResponseEntity.ok().body(dto);
    }

    @PostMapping
    public ResponseEntity<BookDTO> insertBook(@RequestBody BookDTO dto) {
        BookDTO savedDTO = service.insertBook(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedDTO.id())
                .toUri();

        return ResponseEntity.created(uri).body(savedDTO);
    }

    @PostMapping("batch")
    public ResponseEntity<List<BookDTO>> insertMultipleBooks(@RequestBody List<BookDTO> dtos) {
        List<BookDTO> savedList = service.insertMultipleBooks(dtos);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().build().toUri();
        return ResponseEntity.created(uri).body(savedList);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookDTO dto) {
        return service.bookExists(id)
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(service.updateBook(id, dto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<BookDTO> deleteBookById(@PathVariable Long id) {
        service.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }
}
