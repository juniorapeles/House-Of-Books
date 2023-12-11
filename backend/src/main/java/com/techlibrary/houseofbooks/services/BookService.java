package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
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

    public BookDTO getBookById(Long id) {
        Optional <Book> bookOptional = repository.findById(id);

        Book entity = bookOptional.orElseThrow(() -> new ResourceNotFoundException("Book not Found"));
        return new BookDTO(entity);
    }

    public BookDTO CreateBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        repository.save(book);
        return new BookDTO(book);
    }

    public void DeleteBook(Long id){
        repository.deleteById(id);
    }
}
