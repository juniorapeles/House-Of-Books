package com.techlibrary.houseofbooks.service.base;

import com.techlibrary.houseofbooks.domain.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
