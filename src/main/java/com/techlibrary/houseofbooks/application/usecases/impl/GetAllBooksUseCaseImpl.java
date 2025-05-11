package com.techlibrary.houseofbooks.application.usecases.impl;

import com.techlibrary.houseofbooks.application.usecases.GetAllBooksUseCase;
import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.infrastructure.persistence.BookJpaAdapter;

import java.util.List;

public class GetAllBooksUseCaseImpl implements GetAllBooksUseCase {

    private final BookJpaAdapter bookJpaAdapter;

    public GetAllBooksUseCaseImpl(BookJpaAdapter bookJpaAdapter) {
        this.bookJpaAdapter = bookJpaAdapter;
    }

    @Override
    public List<BookDTO> execute() {
        return bookJpaAdapter.execute();
    }
}
