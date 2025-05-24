package com.example.library_service.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String s) {
        super(s);
    }
}
