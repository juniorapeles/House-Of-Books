package com.techlibrary.houseofbooks.datasource.impl;

import com.techlibrary.houseofbooks.datasource.def.CreateBookUseCase;
import com.techlibrary.houseofbooks.datasource.dto.BookDTO;
import com.techlibrary.houseofbooks.service.base.BookJpaAdapter;

public class CreateBookUseCaseImpl implements CreateBookUseCase {

    private final BookJpaAdapter bookJpaAdapter;

    public CreateBookUseCaseImpl(BookJpaAdapter bookJpaAdapter) {
        this.bookJpaAdapter = bookJpaAdapter;
    }

    @Override
    public BookDTO execute(BookDTO dto) {
        return bookJpaAdapter.execute(dto);
    }

}
