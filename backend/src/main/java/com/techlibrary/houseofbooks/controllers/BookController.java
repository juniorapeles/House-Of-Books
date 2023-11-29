package com.techlibrary.houseofbooks.controllers;


import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public Optional<Book> getBooksById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return service.CreateBook(book);
    }

    @DeleteMapping("/{id}")
    public void DeleteBook(@PathVariable Long id){
        service.DeleteBook(id);
    }

}
