package com.techlibrary.houseofbooks.datasource.def.book;

import com.techlibrary.houseofbooks.service.dto.BookDTO;

public interface UpdateBookUseCase {
    BookDTO execute(Long id, BookDTO bookDTO);
}
