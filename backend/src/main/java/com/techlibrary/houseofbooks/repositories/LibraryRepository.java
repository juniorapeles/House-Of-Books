package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.Library;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {
}