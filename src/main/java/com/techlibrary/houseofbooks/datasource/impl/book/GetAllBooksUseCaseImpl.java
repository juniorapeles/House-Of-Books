package com.techlibrary.houseofbooks.datasource.impl.book;

import com.techlibrary.houseofbooks.datasource.def.book.GetAllBooksUseCase;
import com.techlibrary.houseofbooks.service.dto.BookDTO;
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
