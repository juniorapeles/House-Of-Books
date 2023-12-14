package com.techlibrary.houseofbooks.services.exceptions;

public class BookBorrowedException extends RuntimeException{
    private static final long  serialVersionUID = 1L;

    public BookBorrowedException(String msg){
        super(msg);
    }
}
