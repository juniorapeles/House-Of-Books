package com.techlibrary.features.book.service;

import com.techlibrary.features.book.dto.BookDTO;
import com.techlibrary.features.book.domain.Book;
import com.techlibrary.features.book.mapper.BookMapper;
import com.techlibrary.generics.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService extends GenericServiceImpl<Book, BookDTO, Long, BookMapper> {

    public BookService(JpaRepository<Book, Long> repository, BookMapper mapper) {
        super(repository, mapper);
    }

}