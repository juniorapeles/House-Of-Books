package com.techlibrary.features.loan.dto;


import com.techlibrary.features.book.dto.BookDTO;
import com.techlibrary.features.user.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoanDTO {

    // TODO: Defina os campos do DTO aqui
    private BookDTO book;
    private UserDTO user;
}