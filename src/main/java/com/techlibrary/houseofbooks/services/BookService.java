package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.repositories.AuthorRepository;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.services.exceptions.DatabaseException;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Transactional
    public Page<BookDTO> findAllPaged(Pageable pageable) {
        Page<Book> list = bookRepository.findAll(pageable);
        return list.map(x -> new BookDTO(x));
    }

    public BookDTO FindById(Long id) {
        Optional<Book> obj = bookRepository.findById(id);
        Book entity = obj.orElseThrow(() -> new ResourceNotFoundException("Book not Found"));
        return new BookDTO(entity);
    }

    public BookDTO insertBook(BookDTO dto) {
        Book entity = new Book();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        List<Author> authors = authorRepository.findAll();
        Author existingAuthor = authors.stream()
                .filter(author -> author.getName().equals(dto.getAuthorName()))
                .findFirst()
                .orElse(null);

        if (existingAuthor != null) {

            entity.setAuthor(existingAuthor);
        } else {

            Author newAuthor = new Author();
            newAuthor.setName(dto.getAuthorName());
            newAuthor = authorRepository.save(newAuthor);
            entity.setAuthor(newAuthor);
        }

        entity = bookRepository.save(entity);

        return new BookDTO(entity);
    }


    public BookDTO UpdateBook(Long id, BookDTO dto) {
        try {
            Book entity = bookRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("id not found " + id));

            entity.setName(dto.getName());
            entity.setDescription(dto.getDescription());

            List<Author> authors = authorRepository.findAll();
            Author existingAuthor = authors.stream()
                    .filter(author -> author.getName().equals(dto.getAuthorName()))
                    .findFirst()
                    .orElse(null);

            if (existingAuthor != null) {
                entity.setAuthor(existingAuthor);
            } else {
                Author newAuthor = new Author();
                newAuthor.setName(dto.getAuthorName());
                authorRepository.save(newAuthor);
                entity.setAuthor(newAuthor);
            }
            entity = bookRepository.save(entity);

            return new BookDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("id not found " + id);
        }
    }

    public void DeleteBook(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch ( EmptyResultDataAccessException e){
            throw new ResourceNotFoundException("id not found " + id);
        } catch (DataIntegrityViolationException e){
            throw new DatabaseException("Integrity violation");
        }
    }

    private void UpdatedBookToBookDTO(BookDTO bookDTO, Book book) {

    }


}
