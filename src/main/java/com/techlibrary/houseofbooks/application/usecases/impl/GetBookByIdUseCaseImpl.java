package com.techlibrary.houseofbooks.application.usecases.impl;

import com.techlibrary.houseofbooks.application.usecases.GetBookByIdUseCase;
import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.infrastructure.persistence.BookJpaAdapter;

public class GetBookByIdUseCaseImpl implements GetBookByIdUseCase {

    private final BookJpaAdapter bookJpaAdapter;

    public GetBookByIdUseCaseImpl(BookJpaAdapter bookJpaAdapter) {
        this.bookJpaAdapter = bookJpaAdapter;
    }

    @Override
    public BookDTO execute(Long id) {
        return bookJpaAdapter.execute(id);
    }
}
