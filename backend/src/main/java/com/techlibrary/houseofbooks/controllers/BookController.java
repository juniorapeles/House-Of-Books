package com.techlibrary.houseofbooks.controllers;


import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

//    @GetMapping
//    public List<BookDTO> getAllBooks(){
//        return service.getAllBooks();
//    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO bookDTO) {
        BookDTO createdBook = service.CreateBook(bookDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }


//    @DeleteMapping("/{id}")
//    public void DeleteBook(@PathVariable Long id){
//        service.DeleteBook(id);
//    }

}
