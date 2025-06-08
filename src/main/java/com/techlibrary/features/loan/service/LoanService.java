package com.techlibrary.features.loan.service;

import com.techlibrary.features.book.domain.Book;
import com.techlibrary.features.book.domain.enums.EStatus;
import com.techlibrary.features.book.repository.BookRepository;
import com.techlibrary.features.loan.domain.Loan;
import com.techlibrary.features.loan.dto.LoanDTO;
import com.techlibrary.features.loan.mapper.LoanMapper;
import com.techlibrary.features.user.domain.User;
import com.techlibrary.features.user.repository.UserRepository;
import com.techlibrary.generics.GenericServiceImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService extends GenericServiceImpl<Loan, LoanDTO, Long, LoanMapper> {

    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public LoanService(JpaRepository<Loan, Long> repository, LoanMapper mapper,
                       BookRepository bookRepository, UserRepository userRepository) {
        super(repository, mapper);
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }

    @Override
    public LoanDTO create(LoanDTO loanDTO) {
        if (loanDTO.getBook() != null && loanDTO.getBook().getId() != null &&
                loanDTO.getUser() != null && loanDTO.getUser().getId() != null) {

            Book book = bookRepository.findById(loanDTO.getBook().getId())
                    .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

            book.setStatus(EStatus.BORROWED);
            bookRepository.save(book);

            User user = userRepository.findById(loanDTO.getUser().getId())
                    .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

            Loan loan = mapper.toEntity(loanDTO);
            loan.setBook(book);
            loan.setUser(user);

            Loan savedLoan = repository.save(loan);

            return mapper.toDTO(savedLoan);
        }

        return super.create(loanDTO);
    }
    public LoanDTO returnLoan(Long loanId) {
        Loan loan = repository.findById(loanId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        Book book = loan.getBook();
        if (book == null) {
            throw new RuntimeException("Livro não associado ao empréstimo");
        }

        book.setStatus(EStatus.AVAILABLE); // Define como disponível
        bookRepository.save(book);

        // Opcional: marcar a data de devolução, status do empréstimo, etc.

        Loan updatedLoan = repository.save(loan); // salva qualquer atualização no empréstimo, se desejar
        return mapper.toDTO(updatedLoan);
    }

}