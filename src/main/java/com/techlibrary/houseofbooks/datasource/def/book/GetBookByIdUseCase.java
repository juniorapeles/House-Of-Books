package com.techlibrary.houseofbooks.datasource.def.book;

import com.techlibrary.houseofbooks.service.dto.BookDTO;

public interface GetBookByIdUseCase {

    BookDTO execute(Long id);
}
