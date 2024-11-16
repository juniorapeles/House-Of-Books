package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findByBorrowedFalse(Pageable pageable);
    Page<Book> findByBorrowedTrue(Pageable pageable);
    Optional<Book> findByName(String name);
}
