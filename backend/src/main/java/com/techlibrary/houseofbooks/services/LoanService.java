package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;
}
