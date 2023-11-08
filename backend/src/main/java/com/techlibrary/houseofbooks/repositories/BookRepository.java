package com.techlibrary.houseofbooks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techlibrary.houseofbooks.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
