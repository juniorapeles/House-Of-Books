package com.techlibrary.houseofbooks.services.exceptions;

public class BookIsNotBorrowedException extends RuntimeException{
    private static final long  serialVersionUID = 1L;

    public BookIsNotBorrowedException(String msg){
        super(msg);
    }
}
