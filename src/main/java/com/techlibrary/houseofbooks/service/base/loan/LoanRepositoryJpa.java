package com.techlibrary.houseofbooks.service.base.loan;

import com.techlibrary.houseofbooks.domain.loan.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepositoryJpa extends JpaRepository<Loan, Integer> {
}
