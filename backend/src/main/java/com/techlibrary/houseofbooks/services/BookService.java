package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;


    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Optional<Book> findById(Long id) {
        return repository.findById(id);
    }

    public Book CreateBook(Book book) {
        return repository.save(book);
    }

    public void DeleteBook(Long id){
        repository.deleteById(id);
    }
}
