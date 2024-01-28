package com.techlibrary.houseofbooks.entities;

import com.techlibrary.houseofbooks.dto.BookDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

@Entity
@Table(name = "tb_book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean borrowed;
    @NotBlank(message = "the 'name' field cannot be blank")
    private String name;
    @ManyToOne
    @JoinColumn(name = "author_id")
    @NotNull(message = "The 'author'  field cannot be null")
    private Author author;
    @Temporal(TemporalType.DATE)
    @NotNull(message = "the 'publication_date' field cannot be null")
    private Date publication_date;

    @NotBlank(message = "the 'name' field cannot be blank")
    private String descricao;

    public Book() {
    }

    public Book(Long id, Boolean borrowed, String name, Author author, Date publication_date, String descricao) {
        this.id = id;
        this.borrowed = borrowed;
        this.name = name;
        this.author = author;
        this.publication_date = publication_date;
        this.descricao = descricao;
    }
}


