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

        // Cria uma nova instância de Book
        Book entity = new Book();

        // Copia propriedades do DTO para a entidade, exceto o autor
        BeanUtils.copyProperties(dto, entity, "author");

        // Verifica se o autor já existe no banco de dados
        Author existingAuthor = authorRepository.findByName(dto.authorName())
                .orElse(null);

        // Cria ou reutiliza o autor
        Author author = (existingAuthor != null)
                ? existingAuthor
                : authorRepository.save(new Author(dto.authorName(), dto.description()));

        // Associa o autor ao livro
        entity.setAuthor(author);

        // Salva o livro no banco de dados
        entity = bookRepository.save(entity);

        // Retorna o DTO do livro salvo
        return new BookDTO(entity);
    }


    public BookDTO updateBook(Long id, BookDTO dto) {
        try {
            Book entity = bookRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException(MSG_ID_NOT_FOUND + id));

            BeanUtils.copyProperties(dto, entity);

            List<Author> authors = authorRepository.findAll();
            Author existingAuthor = authors.stream()
                    .filter(author -> author.getName().equals(dto.authorName()))
                    .findFirst()
                    .orElse(null);

            if (existingAuthor != null) {
                entity.setAuthor(existingAuthor);
            } else {
                Author newAuthor = new Author();
                newAuthor.setName(dto.authorName());
                authorRepository.save(newAuthor);
                entity.setAuthor(newAuthor);
            }
            entity = bookRepository.save(entity);
            return new BookDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(MSG_ID_NOT_FOUND + id);
        }
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
}
