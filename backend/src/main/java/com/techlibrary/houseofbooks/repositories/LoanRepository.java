package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository <Loan, Long> {
}

