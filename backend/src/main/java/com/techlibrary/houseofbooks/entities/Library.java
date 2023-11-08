package com.techlibrary.houseofbooks.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "tb_library")
public class Library implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "library")
    private List<Book> books;

    public Library() {
    }

    public Library(Long id, String name, List<Book> books) {
        this.id = id;
        this.name = name;
        this.books = books;
    }

}
