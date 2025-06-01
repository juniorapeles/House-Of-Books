package com.techlibrary.houseofbooks.datasource.def.book;

import com.techlibrary.houseofbooks.service.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetAllBooksUseCase {
    List<BookDTO> execute();
}
