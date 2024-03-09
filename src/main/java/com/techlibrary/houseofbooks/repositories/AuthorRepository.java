package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
