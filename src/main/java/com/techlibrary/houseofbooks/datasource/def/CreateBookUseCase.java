package com.techlibrary.houseofbooks.datasource.def;

import com.techlibrary.houseofbooks.datasource.dto.BookDTO;

public interface CreateBookUseCase {
    BookDTO execute(BookDTO bookDTO);
}
