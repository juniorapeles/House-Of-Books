package com.techlibrary.features.book.controller;

import com.techlibrary.generics.GenericController;
import com.techlibrary.features.book.dto.BookDTO;
import com.techlibrary.generics.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController extends GenericController<BookDTO, Long> {

    public BookController(GenericService<BookDTO, Long> service) {
        super(service);
    }

}