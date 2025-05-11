package com.techlibrary.houseofbooks.application.usecases.impl;

import com.techlibrary.houseofbooks.application.usecases.DeleteBookByIdUseCase;
import com.techlibrary.houseofbooks.infrastructure.persistence.BookJpaAdapter;

public class DeleteBookByIdUseCaseImpl implements DeleteBookByIdUseCase {

    private final BookJpaAdapter bookJpaAdapter;

    public DeleteBookByIdUseCaseImpl(BookJpaAdapter bookJpaAdapter) {
        this.bookJpaAdapter = bookJpaAdapter;
    }

    @Override
    public void deleteBookById(Long id) {
        bookJpaAdapter.deleteBookById(id);
    }
}
