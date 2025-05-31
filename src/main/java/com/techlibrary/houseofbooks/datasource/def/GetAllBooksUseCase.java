package com.techlibrary.houseofbooks.datasource.def;

import com.techlibrary.houseofbooks.datasource.dto.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GetAllBooksUseCase {
    List<BookDTO> execute();
}
