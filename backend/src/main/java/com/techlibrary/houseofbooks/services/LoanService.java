package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.LoanDTO;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.entities.Loan;
import com.techlibrary.houseofbooks.entities.User;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.repositories.LoanRepository;
import com.techlibrary.houseofbooks.repositories.UserRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Loan> GetAllBorrowBooks() {
        return repository.findAll();
    }

    public LoanDTO BorrowBook(Long bookId, Long userId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Optional<User> userOptional = userRepository.findById(userId);

        Book bookEntity = bookOptional.orElseThrow(() -> new ResourceNotFoundException("Book not found"));
        User userEntity = userOptional.orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Loan loan = new Loan(bookEntity, userEntity);
        repository.save(loan);

        return new LoanDTO(loan) ;
    }

    public LoanDTO GetBorrowBookById(Long id) {
        Optional<Loan> loanOptional = repository.findById(id);

        Loan entity  = loanOptional.orElseThrow(()  -> new ResourceNotFoundException("Loan Not Found"));
        return new LoanDTO(entity);

    }
}
