package com.techlibrary.houseofbooks.infrastructure.persistence;

import com.techlibrary.houseofbooks.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
