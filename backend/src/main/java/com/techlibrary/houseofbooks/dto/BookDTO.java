package com.techlibrary.houseofbooks.dto;

import com.techlibrary.houseofbooks.entities.Book;

import java.io.Serializable;

/**
 * Data Transfer Object (DTO) para representar informações simplificadas de um livro.
 */
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
    private String author;

    public BookDTO() {
    }

    /**
     * Construtor que converte uma instância de Book em um BookDTO.
     * @param entity A instância de Book a ser convertida.
     */
    public BookDTO(Book entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.author = entity.getAuthor();
    }

    // Getters e setters

    /**
     * Obtém o ID do livro.
     * @return O ID do livro.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID do livro.
     * @param id O ID do livro.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome do livro.
     * @return O nome do livro.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome do livro.
     * @param name O nome do livro.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém o autor do livro.
     * @return O autor do livro.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Define o autor do livro.
     * @param author O autor do livro.
     */
    public void setAuthor(String author) {
        this.author = author;
    }
}
