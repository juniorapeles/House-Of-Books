package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<BookDTO> getAllBooks() {
        List<Book> allBooks = repository.findAll();

        List<BookDTO> allBooksDTOs = allBooks.stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
        return allBooksDTOs;
    }

    public List<BookDTO> getAvailableBooks() {
        List<Book> availableBooks = repository.findByBorrowedFalse();

        return availableBooks.stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    public BookDTO getBookById(Long id) {
        Optional<Book> bookOptional = repository.findById(id);

        Book entity = bookOptional.orElseThrow(() -> new ResourceNotFoundException("Book not Found"));
        return new BookDTO(entity);
    }

    public BookDTO CreateBook(BookDTO bookDTO) {
        Book book = new Book(bookDTO);
        repository.save(book);
        return new BookDTO(book);
    }

    public BookDTO UpdateBook(Long id, BookDTO bookDTO) {
        Optional<Book> obj = repository.findById(id);
        Book entity = obj.orElseThrow(() -> new ResourceNotFoundException("Book Not Found"));
        modelMapper.getConfiguration().setSkipNullEnabled(true);
        modelMapper.map(bookDTO,entity);
        repository.save(entity);
        return new BookDTO(entity);
    }

    public void DeleteBook(Long id) {
        repository.deleteById(id);
    }



}
