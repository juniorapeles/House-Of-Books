package com.techlibrary.houseofbooks.datasource.def;

import com.techlibrary.houseofbooks.datasource.dto.BookDTO;

public interface UpdateBookUseCase {
    BookDTO execute(Long id, BookDTO bookDTO);
}
