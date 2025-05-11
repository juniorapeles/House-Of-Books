package com.techlibrary.houseofbooks.application.usecases;

import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;

public interface GetBookByIdUseCase {

    BookDTO execute(Long id);
}
