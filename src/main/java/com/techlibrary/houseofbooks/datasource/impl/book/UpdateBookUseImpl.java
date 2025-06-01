package com.techlibrary.houseofbooks.datasource.impl.book;

import com.techlibrary.houseofbooks.datasource.def.book.UpdateBookUseCase;
import com.techlibrary.houseofbooks.service.dto.BookDTO;
import com.techlibrary.houseofbooks.service.base.BookJpaAdapter;

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
