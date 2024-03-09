package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    boolean existsByBookId(Long bookId);
    Optional<Loan> findByBookId(Long bookId);
}
