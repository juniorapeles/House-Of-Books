package com.techlibrary.houseofbooks.application.usecases.impl;

import com.techlibrary.houseofbooks.application.usecases.UpdateBookUseCase;
import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.infrastructure.persistence.BookJpaAdapter;

public class UpdateBookUseImpl implements UpdateBookUseCase {

    private final BookJpaAdapter bookJpaAdapter;

    public UpdateBookUseImpl(BookJpaAdapter bookJpaAdapter) {
        this.bookJpaAdapter = bookJpaAdapter;
    }

    @Override
    public BookDTO execute(Long id, BookDTO bookDTO) {
        return bookJpaAdapter.execute(id, bookDTO);
    }

}
