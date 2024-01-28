package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.AuthorDTO;
import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.Author;
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

    public BookDTO CreateBook(BookDTO bookDTO) {

        Book book = new BookDTO();

        repository.save(book);

        return new BookDTO(BookDTO);

    }
}
