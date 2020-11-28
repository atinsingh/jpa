package io.pragra.learning.jpademo.exceptions;


public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message) {
        super(message);
    }
}
