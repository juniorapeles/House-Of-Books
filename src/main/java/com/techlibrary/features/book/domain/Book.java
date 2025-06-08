package com.techlibrary.features.book.domain;

import com.techlibrary.features.book.domain.enums.EStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // TODO: Defina de Book aqui.
    private String title;
    private String author;
    @Enumerated(EnumType.STRING)
    private EStatus status;
}