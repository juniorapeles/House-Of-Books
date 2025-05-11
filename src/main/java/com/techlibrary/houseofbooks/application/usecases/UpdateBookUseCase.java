package com.techlibrary.houseofbooks.application.usecases;

import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;

public interface UpdateBookUseCase {
    BookDTO execute(Long id, BookDTO bookDTO);
}
