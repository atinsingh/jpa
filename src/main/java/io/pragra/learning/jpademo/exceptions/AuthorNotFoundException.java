package io.pragra.learning.jpademo.exceptions;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String s) {
        super(s);
    }
}
