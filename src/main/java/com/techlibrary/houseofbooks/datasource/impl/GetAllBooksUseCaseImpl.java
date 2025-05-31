package com.techlibrary.houseofbooks.datasource.impl;

import com.techlibrary.houseofbooks.datasource.def.GetAllBooksUseCase;
import com.techlibrary.houseofbooks.datasource.dto.BookDTO;
import com.techlibrary.houseofbooks.service.base.BookJpaAdapter;

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
