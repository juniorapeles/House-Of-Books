package com.techlibrary.features.book.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookDTO {

    // TODO: Defina os campos do DTO aqui
    private Long id;
    private String title;
    private String author;
}