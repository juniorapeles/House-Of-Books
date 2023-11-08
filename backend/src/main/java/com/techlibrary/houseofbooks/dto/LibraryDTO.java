package com.techlibrary.houseofbooks.dto;

import java.util.List;

/**
 * Data Transfer Object (DTO) para representar informações simplificadas de uma biblioteca.
 */
public class LibraryDTO {
    private Long id;
    private String name;
    private List<BookDTO> books; // Use BookDTO para representar a lista de livros

    public LibraryDTO() {
    }

    /**
     * Construtor para criar uma instância de LibraryDTO com ID, nome e lista de livros.
     * @param id O ID da biblioteca.
     * @param name O nome da biblioteca.
     * @param books A lista de livros associados à biblioteca.
     */
    public LibraryDTO(Long id, String name, List<BookDTO> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

    /**
     * Obtém o ID da biblioteca.
     * @return O ID da biblioteca.
     */
    public Long getId() {
        return id;
    }

    /**
     * Define o ID da biblioteca.
     * @param id O ID da biblioteca.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtém o nome da biblioteca.
     * @return O nome da biblioteca.
     */
    public String getName() {
        return name;
    }

    /**
     * Define o nome da biblioteca.
     * @param name O nome da biblioteca.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtém a lista de livros associados à biblioteca.
     * @return A lista de livros associados à biblioteca.
     */
    public List<BookDTO> getBooks() {
        return books;
    }

    /**
     * Define a lista de livros associados à biblioteca.
     * @param books A lista de livros associados à biblioteca.
     */
    public void setBooks(List<BookDTO> books) {
        this.books = books;
    }
}
