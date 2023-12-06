package com.techlibrary.houseofbooks.controllers;


import com.techlibrary.houseofbooks.dto.AddressDTO;
import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBooksById(@PathVariable Long id){
        BookDTO bookDTO = service.getBookById(id);

        if(bookDTO != null){
            return ResponseEntity.ok(bookDTO);
        }else{
            return null;
        }

    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = service.CreateBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @DeleteMapping("/{id}")
    public void DeleteBook(@PathVariable Long id){
        service.DeleteBook(id);
    }

}
