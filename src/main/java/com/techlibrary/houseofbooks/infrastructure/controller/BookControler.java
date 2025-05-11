package com.techlibrary.houseofbooks.infrastructure.controller;

import com.techlibrary.houseofbooks.application.usecases.*;
import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.domain.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("books")
public class BookControler {

    private final CreateBookUseCase createBookUseCase;
    private final GetAllBooksUseCase getAllBooksUseCase;
    private final GetBookByIdUseCase getBookByIdUseCase;
    private final UpdateBookUseCase updateBookUseCase;
    private final DeleteBookByIdUseCase deleteBookByIdUseCase;

    public BookControler(CreateBookUseCase createBookUseCase, GetAllBooksUseCase getAllBooksUseCase,
                         GetBookByIdUseCase getBookByIdUseCase, UpdateBookUseCase updateBookUseCase,
                         DeleteBookByIdUseCase deleteBookByIdUseCase) {
        this.createBookUseCase = createBookUseCase;
        this.getAllBooksUseCase = getAllBooksUseCase;
        this.getBookByIdUseCase = getBookByIdUseCase;
        this.updateBookUseCase = updateBookUseCase;
        this.deleteBookByIdUseCase = deleteBookByIdUseCase;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return getAllBooksUseCase.execute();
    }

    @GetMapping("/{id}")
    public BookDTO getBookById(@PathVariable Long id) {
        return getBookByIdUseCase.execute(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public BookDTO createBook(@RequestBody BookDTO bookDTO) {
        return createBookUseCase.execute(bookDTO);
    }

    @PutMapping("/{id}")
    public BookDTO updateBookById(@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        return updateBookUseCase.execute(id, bookDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteBookById(@PathVariable Long id) {
        deleteBookByIdUseCase.deleteBookById(id);
    }
}
