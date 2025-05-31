package com.techlibrary.houseofbooks.domain.model;

import com.techlibrary.houseofbooks.datasource.dto.BookDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.envers.Audited;

@Entity
@Table(name = "tb_book")
@Audited
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String author;
    private String isbn;

    public Book(BookDTO dto) {
        this.title = dto.getTitle();
        this.author = dto.getAuthor();
        this.isbn = dto.getIsbn();
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }
}
