package com.techlibrary.houseofbooks.controllers;

import com.techlibrary.houseofbooks.controllers.generic.GenericController;
import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.services.generics.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("livros")
public class BookController extends GenericController<BookDTO, Long> {

    protected BookController(GenericService<BookDTO, Long> service) {
        super(service);
    }
}
