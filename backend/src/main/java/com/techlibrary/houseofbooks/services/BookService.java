package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.AuthorDTO;
import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.services.exceptions.DatabaseException;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    @Transactional
    public Page<BookDTO> findAllPaged(PageRequest pageRequest) {
        Page<Book> list = repository.findAll(pageRequest);
        return list.map(x -> new BookDTO(x));
    }

    public BookDTO FindById(Long id) {
        Optional<Book> obj = repository.findById(id);
        Book entity = obj.orElseThrow(() -> new ResourceNotFoundException("Book not Found"));
        return new BookDTO(entity);
    }

    public BookDTO InsertBook(BookDTO dto) {
        Book entity = new Book();
        UpdatedBookToBookDTO(dto, entity);
        entity = repository.save(entity);
        return new BookDTO(entity);
    }


    public BookDTO UpdateBook(Long id, BookDTO dto) {
        try{
            Book entity = repository.getReferenceById(id);
            entity.setName(dto.getName());
            return new BookDTO(entity);
        } catch ( EntityNotFoundException e){
            throw new ResourceNotFoundException("id not found " + id);
        }
    }

    public void DeleteBook(Long id) {
        try {
            repository.deleteById(id);
        } catch ( EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("id not found " + id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }

    private void UpdatedBookToBookDTO(BookDTO bookDTO, Book book) {
        book.setId(bookDTO.getId());
        book.setName(bookDTO.getName());
        book.setBorrowed(bookDTO.getBorrowed());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
    }
}
