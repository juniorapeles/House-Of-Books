package com.techlibrary.houseofbooks.service.base;

import com.techlibrary.houseofbooks.datasource.def.book.*;
import com.techlibrary.houseofbooks.service.dto.BookDTO;
import com.techlibrary.houseofbooks.domain.book.Book;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BookJpaAdapter implements CreateBookUseCase, DeleteBookByIdUseCase, GetAllBooksUseCase,
        GetBookByIdUseCase, UpdateBookUseCase {

    private final BookRepository bookRepository;

    public BookJpaAdapter(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public BookDTO execute(BookDTO dto) {
        Book book = new Book(dto);
        bookRepository.save(book);
        return new BookDTO(book);
    }

    @Override
    public List<BookDTO> execute() {
       return bookRepository.findAll()
               .stream()
               .map(BookDTO::new)
               .collect(Collectors.toList());
    }

    @Override
    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public BookDTO execute(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));
        return new BookDTO(book);
    }

    @Override
    public BookDTO execute(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado com o ID: " + id));

        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setIsbn(bookDTO.getIsbn());

        Book updatedBook = bookRepository.save(book);

        return new BookDTO(updatedBook);
    }


}
