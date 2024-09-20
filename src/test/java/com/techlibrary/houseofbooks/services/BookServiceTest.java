package com.techlibrary.houseofbooks.services;

import com.techlibrary.houseofbooks.dto.BookDTO;
import com.techlibrary.houseofbooks.entities.Author;
import com.techlibrary.houseofbooks.entities.Book;
import com.techlibrary.houseofbooks.mapper.BookMapper;
import com.techlibrary.houseofbooks.repositories.AuthorRepository;
import com.techlibrary.houseofbooks.repositories.BookRepository;
import com.techlibrary.houseofbooks.services.exceptions.ResourceNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BookServiceTest {

    @InjectMocks
    private BookService bookService;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private AuthorRepository authorRepository;

    @Mock
    private BookMapper bookMapper;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    private Author createAuthor(String name) {
        Author author = new Author();
        author.setName(name);
        return author;
    }

    private Book createBook(Long id, String name, String description, Author author) {
        Book book = new Book();
        book.setId(id);
        book.setName(name);
        book.setDescription(description);
        book.setAuthor(author);
        return book;
    }

    private BookDTO createBookDTO(String name, String description, String authorName) {
        BookDTO bookDTO = new BookDTO();
        bookDTO.setName(name);
        bookDTO.setDescription(description);
        bookDTO.setAuthorName(authorName);
        return bookDTO;
    }

    @Test
    public void testInsertBook() {

        Author author = createAuthor("George Orwell");
        BookDTO bookDTO = createBookDTO("1984", "Dystopian novel", "George Orwell");

        Book book = createBook(null, "1984", "Dystopian novel", author);

        when(authorRepository.findAll()).thenReturn(Collections.singletonList(author));
        when(authorRepository.save(any(Author.class))).thenReturn(author);
        when(bookMapper.toEntity(any(BookDTO.class))).thenReturn(book);
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        when(bookMapper.toDTO(any(Book.class))).thenReturn(bookDTO);


        BookDTO result = bookService.insertBook(bookDTO);

        verify(authorRepository, times(1)).findAll();
        verify(bookRepository, times(1)).save(any(Book.class));
        assertEquals("1984", result.getName());
        assertEquals("Dystopian novel", result.getDescription());
        assertEquals("George Orwell", result.getAuthorName());
    }

    @Test
    public void testFindById() {
        Long bookId = 1L;
        Author author = createAuthor("George Orwell");
        Book book = createBook(bookId, "1984", "Dystopian novel", author);

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(book));
        when(bookMapper.toDTO(book)).thenReturn(new BookDTO(book));

        BookDTO result = bookService.findById(bookId);

        assertEquals(bookId, result.getId());
        assertEquals("1984", result.getName());
        assertEquals("Dystopian novel", result.getDescription());
        assertEquals("George Orwell", result.getAuthorName());
    }

    @Test
    public void testUpdateBook() {
        Long bookId = 1L;
        Author author = createAuthor("George Orwell");
        Book existingBook = createBook(bookId, "1984", "Dystopian novel", author);
        BookDTO bookDTO = createBookDTO("1984 Revised", "Updated description", "George Orwell");

        when(bookRepository.findById(bookId)).thenReturn(Optional.of(existingBook));
        when(authorRepository.findAll()).thenReturn(Collections.singletonList(author));
        when(bookMapper.toEntity(any(BookDTO.class))).thenReturn(existingBook);
        when(bookRepository.save(any(Book.class))).thenReturn(existingBook);
        when(bookMapper.toDTO(any(Book.class))).thenReturn(bookDTO);

        BookDTO result = bookService.updateBook(bookId, bookDTO);

        assertEquals("1984 Revised", result.getName());
        assertEquals("Updated description", result.getDescription());
        assertEquals("George Orwell", result.getAuthorName());
    }

    @Test
    public void testDeleteBookById() {
        Long bookId = 1L;

        doNothing().when(bookRepository).deleteById(bookId);

        bookService.deleteBookById(bookId);

        verify(bookRepository, times(1)).deleteById(bookId);
    }

    @Test
    public void testDeleteBookByIdThrowsException() {
        Long bookId = 1L;
        doThrow(new EmptyResultDataAccessException(1)).when(bookRepository).deleteById(bookId);

        assertThrows(ResourceNotFoundException.class, () -> bookService.deleteBookById(bookId));
    }
}
