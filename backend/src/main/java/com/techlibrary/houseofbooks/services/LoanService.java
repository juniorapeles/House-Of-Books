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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanrepository;

    @Autowired
    private BookRepository bookrepository;

    @Autowired
    private UserRepository userRepository;



//    @Transactional
//    public Page<LoanDTO> findAllPaged(PageRequest pageRequest) {
//        Page<Loan> list = Loanrepository.findAll(pageRequest);
//        return list.map(x -> new LoanDTO(x));
//    }
//
    public LoanDTO FindById(Long id) {
        Optional<Loan> obj = loanrepository.findById(id);
        Loan entity = obj.orElseThrow(() -> new ResourceNotFoundException("Loan not Found"));
        return new LoanDTO(entity);
    }

    public Loan insertLoan(LoanDTO dto) {
        Book book = bookrepository.findById(dto.getBookId())
                .orElseThrow(() -> new ResourceNotFoundException("O livro não foi encontrado " + dto.getBookId()));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("O Usuário não foi encontrado " + dto.getUserId()));

        book.setBorrowed(true);
        Loan loan = new Loan();
        loan.setUser(user);
        loan.setBook(book);

        return loanrepository.save(loan);
    }


//    public BookDTO UpdateBook(Long id, BookDTO dto) {
//        try{
//            Book entity = repository.getReferenceById(id);
//            entity.setName(dto.getName());
//            return new BookDTO(entity);
//        } catch ( EntityNotFoundException e){
//            throw new ResourceNotFoundException("id not found " + id);
//        }
//    }
//
//    public void DeleteBook(Long id) {
//        try {
//            repository.deleteById(id);
//        } catch ( EmptyResultDataAccessException e){
//            throw new ResourceNotFoundException("id not found " + id);
//        } catch (DataIntegrityViolationException e){
//            throw new DatabaseException("Integrity violation");
//        }
//    }
//
//    private void UpdatedBookToBookDTO(BookDTO bookDTO, Book book) {
//        book.setId(bookDTO.getId());
//        book.setName(bookDTO.getName());
//        book.setBorrowed(bookDTO.getBorrowed());
//        book.setAuthor(bookDTO.getAuthor());
//        book.setDescription(bookDTO.getDescription());
//    }
}

