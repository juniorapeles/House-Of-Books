package com.techlibrary.houseofbooks.datasource.impl.book;

import com.techlibrary.houseofbooks.datasource.def.book.GetBookByIdUseCase;
import com.techlibrary.houseofbooks.service.dto.BookDTO;
import com.techlibrary.houseofbooks.service.base.BookJpaAdapter;

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
