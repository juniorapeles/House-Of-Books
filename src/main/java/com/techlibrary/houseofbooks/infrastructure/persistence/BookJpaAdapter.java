package com.techlibrary.houseofbooks.infrastructure.persistence;

import com.techlibrary.houseofbooks.application.usecases.CreateBookUseCase;
import com.techlibrary.houseofbooks.application.usecases.dto.BookDTO;
import com.techlibrary.houseofbooks.domain.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookJpaAdapter implements CreateBookUseCase {

    private final BookRepossitory bookRepository;

    public BookJpaAdapter(BookRepossitory bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book execute(BookDTO dto) {
        Book book = new Book(
                dto.getTitle(),
                dto.getAuthor()
                , dto.getIsbn());
        return bookRepository.save(book);
    }
}
