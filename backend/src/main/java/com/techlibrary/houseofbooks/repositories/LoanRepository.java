package com.techlibrary.houseofbooks.repositories;

import com.techlibrary.houseofbooks.entities.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<Loan,Long> {

}
