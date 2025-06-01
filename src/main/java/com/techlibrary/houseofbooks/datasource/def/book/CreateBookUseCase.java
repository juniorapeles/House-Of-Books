package com.techlibrary.houseofbooks.datasource.def.book;

import com.techlibrary.houseofbooks.service.dto.BookDTO;

public interface CreateBookUseCase {
    BookDTO execute(BookDTO bookDTO);
}
