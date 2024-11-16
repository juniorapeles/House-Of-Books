package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dtos.BookDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.repositories.AuthorRepository;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.services.exceptions.DatabaseException;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private static final String MSG_ID_NOT_FOUND = "id not found ";
    private static final String MSG_BOOK_NOT_FOUND = "Book not found";

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Transactional
    public Page<BookDTO> findAllPaged(Pageable pageable) {
        Page<Book> list = bookRepository.findAll(pageable);
        return list.map(BookDTO::new);
    }

    public Page<BookDTO> findAvailableBooks(Pageable pageable) {
        Page<Book> list = bookRepository.findByBorrowedFalse(pageable);
        return list.map(BookDTO::new);
    }

    public Page<BookDTO> findByBorrowedTrue(Pageable pageable) {
        Page<Book> list = bookRepository.findByBorrowedTrue(pageable);
        return list.map(BookDTO::new);
    }

    public BookDTO findById(Long id) {
        Optional<Book> obj = bookRepository.findById(id);
        Book entity = obj.orElseThrow(() -> new ResourceNotFoundException(MSG_BOOK_NOT_FOUND));
        return new BookDTO(entity);
    }

    public BookDTO insertBook(BookDTO dto) {
        Book entity = new Book();
        BeanUtils.copyProperties(dto, entity, "author");

        Author existingAuthor = authorRepository.findByName(dto.authorName())
                .orElse(null);

        Author author = (existingAuthor != null)
                ? existingAuthor
                : authorRepository.save(new Author(dto.authorName(), dto.description()));
        entity.setAuthor(author);

        entity = bookRepository.save(entity);
        return new BookDTO(entity);
    }

    public BookDTO updateBook(Long id, BookDTO dto) {
        // Verificar se o livro existe no banco de dados
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Book not found"));

        // Atualizar os valores do livro usando o DTO
        book = setDtoUpdateValues(dto, book);

        // Salvar as mudanças no livro
        book = bookRepository.save(book);

        // Retornar o DTO atualizado
        return new BookDTO(book);
    }



    public void deleteBookById(Long id) {
        try {
            bookRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(MSG_ID_NOT_FOUND + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Integrity violation");
        }
    }

    public boolean bookExists(Long id) {
        return bookRepository.findById(id).isPresent();
    }

    public List<BookDTO> insertMultipleBooks(List<BookDTO> dtos) {
        List<BookDTO> savedBooksDTO = new ArrayList<>();

        for (BookDTO dto : dtos) {
            Book entity = new Book();
            BeanUtils.copyProperties(dto, entity, "author");
            Author existingAuthor = authorRepository.findByName(dto.authorName())
                    .orElse(null);
            Author author = (existingAuthor != null)
                    ? existingAuthor
                    : authorRepository.save(new Author(dto.authorName(), dto.description()));

            entity.setAuthor(author);
            entity = bookRepository.save(entity);
            savedBooksDTO.add(new BookDTO(entity));
        }
        return savedBooksDTO;
    }

    public Book setDtoUpdateValues(BookDTO dto, Book entity) {
        // Atualiza os valores do livro
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        entity.setBorrowed(dto.borrowed());
        entity.setAuthor(validaOuCriaAuthor(dto.authorName(), dto.description()));
        return entity;
    }

    public Author validaOuCriaAuthor(String authorName, String description) {
        // Verificar se o autor já existe no banco de dados
        Author existingAuthor = authorRepository.findByName(authorName)
                .orElse(null);

        // Se o autor não existe, cria um novo e salva no banco
        Author author = (existingAuthor != null)
                ? existingAuthor
                : authorRepository.save(new Author(authorName, description));

        return author;
    }
}
