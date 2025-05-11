package com.techlibrary.houseofbooks.infrastructure.controller;

import com.techlibrary.houseofbooks.application.usecases.CreateBookUseCase;
import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.domain.model.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("books")
public class BookControler {

    private final CreateBookUseCase createBookUseCase;

    public BookControler(CreateBookUseCase createBookUseCase) {
        this.createBookUseCase = createBookUseCase;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book createBook(@RequestBody BookDTO bookDTO){
        return createBookUseCase.execute(bookDTO);
    }
}
