package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.LoanDTO;
import com.techlibrary.houseofbooks.dto.LoanRequestDTO;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.entities.Loan;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.repositories.LoanRepository;
import com.techlibrary.houseofbooks.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    @Autowired
    private LoanRepository repostory;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public boolean isBookAvailableForBorrow(Long bookId){
        Optional<Book> optionalBook = bookRepository.findById(bookId);
        return optionalBook.map(Book::isAvailable).orElse(false);
    }

    private void updateBookAvailability(Long bookId, boolean available) {
        Optional<Book> optionalBook =  bookRepository.findById(bookId);
        optionalBook.ifPresent(book -> {
            book.setAvailable(available);
            bookRepository.save(book);
        });
    }
    public LoanDTO borrow(LoanRequestDTO loanRequestDTO) {
       Long bookId = loanRequestDTO.getBookId();

       if(isBookAvailableForBorrow(bookId)) {
           Loan loan = new Loan();

           loan.setStartDate(new Date());
           loan.setDueDate(loanRequestDTO.getDueDate());
           loan.setStatus("Borrowed");
           loan.setUser(userRepository.findById(loanRequestDTO.getUserId()).orElse(null));

           updateBookAvailability(bookId, false);

           List<Book> books = bookRepository.findAllById(loanRequestDTO.getBookIds());

           repostory.save(loan);

           LoanDTO loanDto = new LoanDTO();

           loanDto.setId(loan.getId());
           loanDto.setStartDate(loan.getStartDate());
           loanDto.setDueDate(loan.getDueDate());
           loanDto.setStatus(loan.getStatus());

           return loanDto;
       }else {
           return null;
       }
    }
}
