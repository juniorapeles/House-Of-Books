package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
