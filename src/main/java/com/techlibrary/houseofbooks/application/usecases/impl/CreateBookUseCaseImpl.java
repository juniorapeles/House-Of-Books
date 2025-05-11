package com.techlibrary.houseofbooks.application.usecases.impl;

import com.techlibrary.houseofbooks.application.usecases.CreateBookUseCase;
import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.domain.model.Book;
import com.techlibrary.houseofbooks.infrastructure.persistence.BookJpaAdapter;

public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private final BookJpaAdapter bookJpaAdapter;

    public CreateBookUseCaseImpl(BookJpaAdapter bookJpaAdapter) {
        this.bookJpaAdapter = bookJpaAdapter;
    }

    @Override
    public Book execute(BookDTO dto) {
        return bookJpaAdapter.execute(dto);
    }

}
