package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
