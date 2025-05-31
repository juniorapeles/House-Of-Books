package com.techlibrary.houseofbooks.datasource.impl;

import com.techlibrary.houseofbooks.datasource.def.DeleteBookByIdUseCase;
import com.techlibrary.houseofbooks.service.base.BookJpaAdapter;

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
