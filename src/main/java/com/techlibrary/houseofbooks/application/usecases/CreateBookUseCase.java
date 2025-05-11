package com.techlibrary.houseofbooks.application.usecases;

import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.domain.model.Book;

public interface CreateBookUseCase {

    Book execute(BookDTO bookDTO);
}
