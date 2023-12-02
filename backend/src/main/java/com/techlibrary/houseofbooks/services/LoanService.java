package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.entities.Loan;
import com.techlibrary.houseofbooks.entities.User;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.repositories.LoanRepository;
import com.techlibrary.houseofbooks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public Loan BorrowBook(Long bookId, Long userId) {
        Optional<Book> bookOptional = bookRepository.findById(bookId);
        Optional<User> userOptional = userRepository.findById(userId);

        if(bookOptional.isPresent() && userOptional.isPresent()){
            Book book = bookOptional.get();
            User user = userOptional.get();

            Loan loan = new Loan(book,user);

            return repository.save(loan);
        }else{
            return null;
        }
    }
}
