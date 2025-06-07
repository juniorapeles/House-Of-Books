package com.techlibrary.houseofbooks.services.books;

import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.book.Book;
import com.techlibrary.houseofbooks.mapper.BookMapper;
import com.techlibrary.houseofbooks.services.generics.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends GenericServiceImpl<Book,BookDTO, Long, BookMapper> {

    protected BookService(JpaRepository<Book, Long> repository, BookMapper mapper) {
        super(repository, mapper);
    }
}
