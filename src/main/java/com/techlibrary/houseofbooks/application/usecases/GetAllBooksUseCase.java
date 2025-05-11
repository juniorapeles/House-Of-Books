package com.techlibrary.houseofbooks.application.usecases;

import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetAllBooksUseCase {
    List<BookDTO> execute();
}
