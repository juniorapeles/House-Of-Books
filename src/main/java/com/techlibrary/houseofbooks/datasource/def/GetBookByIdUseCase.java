package com.techlibrary.houseofbooks.datasource.def;

import com.techlibrary.houseofbooks.datasource.dto.BookDTO;

public interface GetBookByIdUseCase {

    BookDTO execute(Long id);
}
