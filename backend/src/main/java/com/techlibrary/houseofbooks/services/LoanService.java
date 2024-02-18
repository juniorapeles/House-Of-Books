package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.LoanDTO;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.entities.Loan;
import com.techlibrary.houseofbooks.entities.User;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.repositories.LoanRepository;
import com.techlibrary.houseofbooks.repositories.UserRepository;
import com.techlibrary.houseofbooks.services.exceptions.BookBorrowedException;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;


    public LoanDTO insertLoan(LoanDTO dto) {

        Book bookEntity = bookRepository.findById(dto.getIdBook())
                .orElseThrow(() -> new ResourceNotFoundException("Book not found with id: " + dto.getIdBook()));

        if (bookEntity.getBorrowed()) {
            throw new BookBorrowedException("Book is already borrowed.");
        } else {
            bookEntity.setBorrowed(true);
            bookRepository.save(bookEntity);
        }


        Optional<User> objUser = userRepository.findById(dto.getIdUser());
        User userEntity = objUser.orElseThrow(() -> new ResourceNotFoundException("User not Found"));

        Loan loanEntity = new Loan(bookEntity, userEntity);
        loanRepository.save(loanEntity);

        return new LoanDTO(loanEntity);
    }
}
